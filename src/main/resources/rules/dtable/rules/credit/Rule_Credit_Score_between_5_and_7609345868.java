package rules.credit;
import java.util.List;import org.apache.camel.loanbroker.credit.CreditHistoryDetails;import org.apache.camel.loanbroker.service.RFQProvider;import rules.credit.*;import org.apache.camel.loanbroker.credit.Customer;import org.apache.camel.loanbroker.credit.CreditScore;import org.drools.core.spi.KnowledgeHelper;import static org.apache.camel.loanbroker.util.CreditScoreUtil.isCustomerOnEP;import static org.apache.camel.loanbroker.util.CreditScoreUtil.isCustomerPR;import static org.apache.camel.loanbroker.util.CreditScoreUtil.isCustomerCitizen;
public class Rule_Credit_Score_between_5_and_7609345868 {
    private static final long serialVersionUID = 510l;

public static void defaultConsequence(KnowledgeHelper drools,  org.apache.camel.loanbroker.credit.CreditScore $creditScore, org.kie.api.runtime.rule.FactHandle $creditScore__Handle__ ,   org.apache.camel.loanbroker.service.RFQProvider rfqProvider ,  java.util.List bankList  ) throws java.lang.Exception { org.kie.api.runtime.rule.RuleContext kcontext = drools;
    System.out.println("Credit Score between 5 and 7"); 
         System.out.println("CreditScore :::"+ $creditScore.getCreditScore()); 
         bankList.addAll(rfqProvider.getListOfBanksBasedOnCreditScore($creditScore.getCreditScore()));
}

}