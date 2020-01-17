package com.application.se2.misc;

import com.application.se2.AppConfigurator.LoggerTopics;
import com.application.se2.model.Entity;
import static com.application.se2.AppConfigurator.LoggerConfig;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.SimpleLayout;

public class LoggerImpl implements Logger {
	 //private final java.util.logging.Logger realLogger;
	// private final org.slf4j.Logger realLogger ;
	 private final org.apache.log4j.Logger realLogger; 
	
	
	public void log(LoggerTopics topic,String msg,Object...args){
		
		
		SimpleLayout layout = new SimpleLayout () ;
		ConsoleAppender consolApender =  new ConsoleAppender ( layout) ;
		this.realLogger.addAppender(consolApender);
		//ALL|DEBUG|INFO|WARN|ERROR|FATAL|OFF:
		this.realLogger.setLevel(Level.ALL);
		
		String id = "<none>";
		String indicator = " - shutdown";

		if( LoggerConfig.contains( topic ) ) {

			switch( topic ) {
			case Always:
			case Info:
			case Warn:
				realLogger.info(msg);
				break;

			case Error:
				System.err.println( "ERROR: " + msg );
				break;

			case EntityCRUD:
				/*
				String cls = "";
				if( args.length > 0 ) {
					Object arg = args[ 0 ];
					arg = arg != null && arg instanceof PrimaryObject? ((PrimaryObject)arg).getObject() : arg;
					id = arg instanceof Entity? ((Entity)arg).getId() : String.valueOf( arg.hashCode() );
					cls= arg.getClass().getSimpleName();
				}
				realLogger.info(msg);
				*/
				StringBuffer sb = new StringBuffer( msg );
				for( Object arg : args ) {
					sb.append( arg.toString() );
				}
				realLogger.info(msg);
				break;

			case Startup:
				indicator = " + startup";
			case Shutdown:
				realLogger.info(msg);
				break;

			case PropertiesAltered:
			case FieldAccessAltered:
				realLogger.info(msg);
				break;

			case RepositoryLoaded:
				if( args.length > 0 ) {
					Object arg = args[ 0 ];
					arg = arg != null && arg instanceof Traceable? ((Traceable)arg).getRootObject() : arg;
					id = arg instanceof Entity? ((Entity)arg).getId() : String.valueOf( arg.hashCode() );
				}
				realLogger.info(msg);
				break;

			case CSSLoaded:
				realLogger.info(msg);
				break;

			}
		}
		
	}
	
	/**
	 * Print info message.
	 * @param message log message
	 */
	@Override
	public void info( String message ) {
		log( LoggerTopics.Info, message );
	}


	/**
	 * Print warn message.
	 * @param message log message
	 */
	@Override
	public void warn( String message ) {
		log( LoggerTopics.Warn, message );
	}


	/**
	 * Print error message.
	 * @param message log message
	 * @param exception optional exception object to log.
	 */
	@Override
	public void error( String message, Exception exception ) {
		log( LoggerTopics.Error, message );
	}
	private LoggerImpl (final Class <?> clazz ) {
		//realLogger = java.util.logging.Logger.getLogger(clazz.getName());
		realLogger=org.apache.log4j.Logger.getLogger(clazz);
	}
	
	public static Logger getInstance(final Class <?> clazz) {
		return new LoggerImpl(clazz);
	}
}
