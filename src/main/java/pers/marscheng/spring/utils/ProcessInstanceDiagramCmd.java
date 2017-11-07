package pers.marscheng.spring.utils;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.cmd.GetBpmnModelCmd;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityManager;

import java.io.InputStream;
import java.util.List;

/**
 * activiti命令执行类
 *
 * @author marscheng
 * @create 2017-11-01 下午1:49
 */
public class ProcessInstanceDiagramCmd implements Command<InputStream> {
    protected String processInstanceId;

    public ProcessInstanceDiagramCmd(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    @Override
    public InputStream execute(CommandContext commandContext) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        ExecutionEntityManager executionEntityManager = commandContext
                .getExecutionEntityManager();
        ExecutionEntity executionEntity = executionEntityManager
                .findExecutionById(processInstanceId);
        String processDefinitionId = executionEntity.getProcessDefinitionId();

        GetBpmnModelCmd getBpmnModelCmd = new GetBpmnModelCmd(
                processDefinitionId);
        BpmnModel bpmnModel = getBpmnModelCmd.execute(commandContext);
        //当前运行到的节点名称
        List<String> activityIds = runtimeService.getActiveActivityIds(processInstanceId);

        //activiti 5.16后改成这样,如果想要修改生成流程图的逻辑还可以继承DefaultProcessDiagramGenerator,覆盖里面的方法
        InputStream is = processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator
                ().generateDiagram(bpmnModel,"png",activityIds);

        return is;
    }
}
