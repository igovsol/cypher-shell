package org.neo4j.shell.state;

import org.neo4j.driver.v1.AuthToken;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.shell.ConnectionConfig;
import org.neo4j.shell.TestDriver;
import org.neo4j.shell.exception.CommandException;

import javax.annotation.Nonnull;

/**
 * Bolt state with faked bolt interactions
 */
public class OfflineBoltStateHandler extends BoltStateHandler {

    public Transaction getCurrentTransaction() {
        return tx;
    }

    public Session getCurrentSession() {
        return session;
    }

    public void connect() throws CommandException {
        connect(new ConnectionConfig("", 1, "", ""));
    }

    @Override
    protected Driver getDriver(@Nonnull ConnectionConfig connectionConfig, AuthToken authToken) {
        return new TestDriver();
    }
}