package org.apache.camel.loanbroker.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.kie.api.KieBase;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class LoanBrokerKeiHelper {
	
	private KieSession kieSession;	
	private StatelessKieSession statelessKieSession;	
	private KieBase kieBase;
	
	
	public LoanBrokerKeiHelper(){
		kieBase = createKBase();
		
	}

	public KieSession getKieSession() {
		return kieBase.newKieSession();
	}

	public StatelessKieSession getStatelessKieSession() {
		return kieBase.newStatelessKieSession();
	}


	public KieBase getKieBase() {
		return kieBase;
	}



	
	public void insertFactToSession(KieSession kieSession,Object fact){
		kieSession.insert(fact);
		kieSession.fireAllRules();
	}
	
	public void insertFactToStatelessSession(Object fact){
		kieSession.insert(fact);
	}



    private  KieBase createKBase(){
		
		KieHelper kieHelper = new KieHelper();		
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/credit/banklist-on-creditScore.drl"), ResourceType.DRL);
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/credit/credit-score-evaluator-for-citizen.drl"), ResourceType.DRL);
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/credit/credit-score-evaluator-for-epholder.drl"), ResourceType.DRL);
		Results results = kieHelper.verify();
		/* results.getMessages().stream().forEach((message) -> {
	            System.out.println(">> Message ( "+message.getLevel()+" ): "+message.getText());
	        });
	        assertThat(false, is(results.hasMessages(Message.Level.ERROR)));*/
		   KieBase kieBase = kieHelper.build();
		
		
		
		return kieBase;
		
	}


}
