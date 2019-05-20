package me.kingtux.tuxjsql.core.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;

public class CPProvider {
    private static ServiceLoader<ConnectionProvider> loader = ServiceLoader
            .load(ConnectionProvider.class);

    public static List<ConnectionProvider> providers(boolean refresh) {
        if (refresh) {
            loader.reload();
        }
        List<ConnectionProvider> providers = new ArrayList<>();
        if (loader.iterator().hasNext()) {
            providers.add(loader.iterator().next());
        }

        return providers;
    }

    public static ConnectionProvider getCP() {

        List<ConnectionProvider> providers = providers(true);
        if (providers.size() == 1) {
            return providers.get(0);
        }
        for (ConnectionProvider provider : providers) {
            if (provider.getClass().getCanonicalName().startsWith("me.kingtux.tuxjsql.basic")) {
                return provider;
            }
        }

        return providers.get(0);
    }
}
