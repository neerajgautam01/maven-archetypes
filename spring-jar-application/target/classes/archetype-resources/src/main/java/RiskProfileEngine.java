#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RiskProfileEngine {

	public static void main(String[] args) {
		final ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath*:application-context.xml");
		final RiskProfileEngine riskProfileEngine = appContext.getBean(RiskProfileEngine.class);
		// riskProfileEngine.processRiskProfileExcelData();
		// ((ConfigurableApplicationContext) appContext).close();
	}

	private void processRiskProfileExcelData() {
		
	}

}
