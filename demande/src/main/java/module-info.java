module insa.fr.soa.demande.module {
    requires jakarta.ws.rs;

    requires org.glassfish.jersey.container.servlet;
    requires org.glassfish.jersey.inject.hk2;

    exports insa.fr.soa.demande;
}