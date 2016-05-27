package rules.credit;
import java.util.List;import org.apache.camel.loanbroker.credit.CreditHistoryDetails;import org.apache.camel.loanbroker.service.RFQProvider;import rules.credit.*;import org.apache.camel.loanbroker.credit.Customer;import org.apache.camel.loanbroker.credit.CreditScore;import org.drools.core.spi.KnowledgeHelper;import static org.apache.camel.loanbroker.util.CreditScoreUtil.isCustomerOnEP;import static org.apache.camel.loanbroker.util.CreditScoreUtil.isCustomerPR;import static org.apache.camel.loanbroker.util.CreditScoreUtil.isCustomerCitizen;
public class Rule_Cutomer_ON_EP_and_income_$u60$_5000137853977 {
    private static final long serialVersionUID = 510l;

public static void defaultConsequence(KnowledgeHelper drools,  java.lang.String $ssn, org.kie.api.runtime.rule.FactHandle $ssn__Handle__   ) throws java.lang.Exception { org.kie.api.runtime.rule.RuleContext kcontext = drools;
    drools.insert( new CreditScore(5,$ssn) );
}

}