package test;

public class Application {

    private final ServiceFactory serviceFactory;

    public Application(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    Service service() {
        return serviceFactory.makeSvc();
    }

    public static void main(String[] args) {
        Application application = new Application(
                new ServiceFactoryImpl()
        );

        Service service = application.service();
    }
}
