import java.util.List;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;

import com.trade.model.TradeInstruction;
import com.trade.model.TradeMock;
import com.trade.tradeimpl.TradingReport;

/**
 * 
 */

/**
 * @author ex22714
 *
 */
public class TradingTest {

	private static List<TradeInstruction> listData;
	private static TradingReport report;
	
	@BeforeClass
	public static void initTradingReport() {
		report = new TradingReport();
		listData = TradeMock.getMockData();
	}
	
	@Test
	public void testReportEntities() {
		report.reportEntities(listData);
	}
	
	@Test
	public void testreportAmountPerDay() {
		report.reportAmountPerDay(listData);
	}

}
