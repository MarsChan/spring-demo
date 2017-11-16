package pers.marscheng.spring.controller;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 流程管理控制类接口
 *
 * @author marscheng
 * @create 2017-11-01 上午9:21
 */
public interface IActivitiController {
    /**
     * 列出所有流程模板
     *
     * @param mav
     * @return
     */
    ModelAndView list(ModelAndView mav);

    /**
     * 部署流程
     * @param processName 流程名称
     * @param mav
     * @return
     */
    ModelAndView deploy(String processName, ModelAndView mav);

    /**
     * 已部署流程列表
     * @param mav
     * @return
     */
    ModelAndView deployed(ModelAndView mav);

    /**
     * 强制删除流程,无论流程是否正在执行,强制删除
     * @param deploymentId
     * @return
     */
    ModelAndView forceRemoveProcess(String deploymentId);

    /**
     * 启动一个流程实例
     * @param id 流程id
     * @param mav
     * @return
     */
    ModelAndView start(String id, ModelAndView mav);

    /**
     * 所有已启动流程实例列表
     * @param mav
     * @return
     */
    ModelAndView started(ModelAndView mav);

    /**
     * 进入任务列表
     * @param mav
     * @return
     */
    ModelAndView task(ModelAndView mav);

    /**
     * 完成当前节点
     * @param mav
     * @param id
     * @return
     */
    ModelAndView complete(ModelAndView mav, String id);

    /**
     * 所有已启动流程实例
     * @param definitionId
     * @param instanceId
     * @param taskId
     * @param mav
     * @param response
     * @throws IOException
     */
    void graphics(String definitionId, String instanceId,
                  String taskId, ModelAndView mav, HttpServletResponse response)
            throws IOException;

}
