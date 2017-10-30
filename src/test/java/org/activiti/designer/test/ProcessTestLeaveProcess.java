package org.activiti.designer.test;

import static org.junit.Assert.*;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/spring-mvc.xml")
public class ProcessTestLeaveProcess {

	// private String filename =
	// "/Users/marscheng/workspaceForDemo/spring-demo/src/main/resources/workflow/leave.bpmn";
	//
	// @Autowired
	// private RepositoryService repositoryService;
	//
	// @Autowired
	// private RuntimeService runtimeService;
	//
	// @Test
	// public void startProcess() throws Exception {
	// repositoryService.createDeployment().addInputStream("leaveProcess.bpmn20.xml",
	// new FileInputStream(filename)).deploy();
	// Map<String, Object> variableMap = new HashMap<String, Object>();
	// variableMap.put("name", "Activiti");
	// ProcessInstance processInstance =
	// runtimeService.startProcessInstanceByKey("leaveProcess", variableMap);
	// assertNotNull(processInstance.getId());
	// System.out.println("id " + processInstance.getId() + " "
	// + processInstance.getProcessDefinitionId());
	// }

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	@Rule
	public ActivitiRule activitiSpringRule;

	@Test
	@Deployment
	public void simpleProcessTest() {
		runtimeService.startProcessInstanceByKey("leaveProcess");
		Task task = taskService.createTaskQuery().singleResult();
		assertEquals("My Task", task.getName());

		taskService.complete(task.getId());
		assertEquals(0, runtimeService.createProcessInstanceQuery().count());

	}
}