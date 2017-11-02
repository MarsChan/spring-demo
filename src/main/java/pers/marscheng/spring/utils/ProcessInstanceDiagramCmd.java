package pers.marscheng.spring.utils;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.impl.cmd.GetBpmnModelCmd;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityManager;

import java.io.InputStream;

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
        ExecutionEntityManager executionEntityManager = commandContext
                .getExecutionEntityManager();
        ExecutionEntity executionEntity = executionEntityManager
                .findExecutionById(processInstanceId);
        String processDefinitionId = executionEntity.getProcessDefinitionId();

        GetBpmnModelCmd getBpmnModelCmd = new GetBpmnModelCmd(
                processDefinitionId);
        BpmnModel bpmnModel = getBpmnModelCmd.execute(commandContext);

        InputStream is = processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator
                ().generatePngDiagram(bpmnModel);

        return is;
    }
}
