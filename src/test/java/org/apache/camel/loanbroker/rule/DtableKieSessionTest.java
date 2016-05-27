package org.apache.camel.loanbroker.rule;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.cxf.helpers.IOUtils;
import org.drools.decisiontable.DecisionTableProviderImpl;
import org.junit.Test;
import org.kie.api.io.Resource;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

public class DtableKieSessionTest  {
	
	
	 /**
     * Converts a decision table into DRL and prints the result in the
     * passed OutputStream.
     * @param decisionTable the decision table to be converted.
     * @param target the stream where the generated DRL will be printed.
     */
    private void printGeneratedDRL(InputStream decisionTable, OutputStream target){
        try {
            DecisionTableProviderImpl dtp = new DecisionTableProviderImpl();
            
            KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
            DecisionTableConfiguration dtconf = KnowledgeBuilderFactory.newDecisionTableConfiguration();
            dtconf.setInputType( DecisionTableInputType.XLS );
            //Resource resource =  ResourceFactory.newClassPathResource("rules/dtable/credit-score.xls");
            
            String drl = dtp.loadFromInputStream(decisionTable,null);
            
            IOUtils.copy(new ByteArrayInputStream(drl.getBytes()), target);
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Test
    public void testSimpleDecisionTable() throws Exception{
    	Resource resource = ResourceFactory.newClassPathResource("rules/dtable/credit-score.csv");
    	 this.printGeneratedDRL(resource.getInputStream(), System.out);
    	
    }

}
