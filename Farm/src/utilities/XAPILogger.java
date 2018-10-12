package utilities;

import ug.ac.mak.java.logger.DailyLogListener;
import ug.ac.mak.java.logger.Log;
import ug.ac.mak.java.logger.Logger;
import ug.ac.mak.java.logger.SimpleLogListener;
import ug.ac.mak.java.logger.SystemMonitor;

public class XAPILogger {
	private static Log log;

	static {
		Logger logger = new Logger();
		logger.addListener(new SimpleLogListener());
		DailyLogListener dailyLogger = new DailyLogListener();
		dailyLogger.setConfiguration("logs/events", "gzip");
		new SystemMonitor(3600000, logger, "venus");
		logger.addListener(dailyLogger);
		log = new Log(logger, "venus");
	}

	public static Log getLogger() {
		return log;
	}
}
