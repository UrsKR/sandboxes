package com.github.signed.sandboxes.jee.multipleears.one;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class OneService {

    @Inject
    public Logger logger;
    @EJB(lookup = "java:global/two-ear-1.0-SNAPSHOT/two-ejb-1.0-SNAPSHOT/OnlyTwo")
    public Two two;


    @PostConstruct
    public void myStart() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        two.dumpToSystemOut();
        logger.info("Start ....................");
        logger.info(getClass().getName() + ": " + new Date());
        logger.info("Finished ....................");
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
    }
}
