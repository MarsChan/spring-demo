package pers.marscheng.spring.controller.impl;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cmd.GetDeploymentProcessDiagramCmd;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pers.marscheng.spring.controller.IActivitiController;
import pers.marscheng.spring.utils.ActivitiUtil;
import pers.marscheng.spring.utils.ProcessInstanceDiagramCmd;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 流程管理控制类
 *
 * @author marscheng
 * @create 2017-11-01 上午9:40
 */
@Controller
@RequestMapping("/process")
public class ActivitiControllerImpl implements IActivitiController {
    @Autowired
    private ProcessEngine engine;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(ModelAndView mav) {
        mav.addObject("list", ActivitiUtil.list());
        mav.setViewName("process/template");
        return mav;
    }

    @Override
    @RequestMapping("deploy")
    public ModelAndView deploy(String processName, ModelAndView mav) {
        if (null != processName)
            repositoryService.createDeployment()
                    .addClasspathResource("workflow/" + processName).deploy();

        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .list();

        mav.addObject("list", list);
        mav.setViewName("process/deployed");
        return mav;
    }

    @Override
    @RequestMapping("deployed")
    public ModelAndView deployed(ModelAndView mav) {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .list();

        mav.addObject("list", list);
        mav.setViewName("process/deployed");

        return mav;
    }

    @Override
    @SuppressWarnings("unchecked")
    @RequestMapping("start")
    public ModelAndView start(String id, ModelAndView mav) {
        runtimeService.startProcessInstanceById(id);

        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery()
                .list();

        mav.addObject("list", list);
        mav.setViewName("process/started");

        return mav;
    }

    @Override
    @RequestMapping("started")
    public ModelAndView started(ModelAndView mav) {
        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery()
                .list();

        mav.addObject("list", list);
        mav.setViewName("process/started");

        return mav;
    }

    @Override
    @RequestMapping("task")
    public ModelAndView task(ModelAndView mav) {
        List<Task> list = taskService.createTaskQuery().list();
        mav.addObject("list", list);
        mav.setViewName("process/task");
        return mav;
    }

    @Override
    @RequestMapping("complete")
    public ModelAndView complete(ModelAndView mav, String id) {
        taskService.complete(id);

        return new ModelAndView("redirect:task");
    }

    @Override
    @RequestMapping("graphics")
    public void graphics(String definitionId, String instanceId, String taskId, ModelAndView
            mav, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        Command<InputStream> cmd = null;

        if (definitionId != null) {
            cmd = new GetDeploymentProcessDiagramCmd(definitionId);
        }

        if (instanceId != null) {
            cmd = new ProcessInstanceDiagramCmd(instanceId);
        }

        if (taskId != null) {
            Task task = engine.getTaskService().createTaskQuery().taskId(taskId).singleResult();
            cmd = new ProcessInstanceDiagramCmd(
                    task.getProcessInstanceId());
        }

        if (cmd != null) {
            InputStream is = engine.getManagementService().executeCommand(cmd);
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = is.read(b, 0, 1024)) != -1) {
                response.getOutputStream().write(b, 0, len);
            }
        }
    }
}
