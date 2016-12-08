package com.inversionas.labs.client.java.ig.streaming.lightstreamer;

import com.lightstreamer.log.Logger;
import com.lightstreamer.log.LoggerProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Slf4jLoggerProvider implements LoggerProvider {

    public Logger getLogger(String s) {

        return new Logger() {
            @Override
            public void error(String s) {
                log.error("", s);
            }

            @Override
            public void error(String s, Throwable t) {
                log.error("{}", s, t);

            }

            @Override
            public void warn(String s) {
                log.warn("{}", s);

            }

            @Override
            public void warn(String s, Throwable t) {
                log.warn("{}", s, t);
            }

            @Override
            public void info(String s) {
                log.info("{}", s);
            }

            @Override
            public void info(String s, Throwable throwable) {
                log.info("{}", s, throwable);
            }

            @Override
            public void debug(String s) {
                log.debug("{}", s);
            }

            @Override
            public void debug(String s, Throwable throwable) {
                log.debug("{}", s, throwable);
            }

            @Override
            public void fatal(String s) {
                error(s);
            }

            @Override
            public void fatal(String s, Throwable throwable) {
                error(s, throwable);
            }

            @Override
            public boolean isDebugEnabled() {
                return log.isDebugEnabled();
            }

            @Override
            public boolean isInfoEnabled() {
                return log.isInfoEnabled();
            }

            @Override
            public boolean isWarnEnabled() {
                return log.isWarnEnabled();
            }

            @Override
            public boolean isErrorEnabled() {
                return log.isErrorEnabled();
            }

            @Override
            public boolean isFatalEnabled() {
                return log.isErrorEnabled();
            }
        };
    }
}
