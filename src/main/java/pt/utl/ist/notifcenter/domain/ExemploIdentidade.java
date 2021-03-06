package pt.utl.ist.notifcenter.domain;

import pt.ist.fenixframework.Atomic;

public class ExemploIdentidade extends ExemploIdentidade_Base {
    
    public ExemploIdentidade() {
        super();
    }

    @Atomic
    public static ExemploIdentidade createExemploIdentidade(final String nome) {
        ExemploIdentidade ex = new ExemploIdentidade();
        ex.setParam1(nome);
        ex.setParam2("string");
        ex.setInt1(123);
        return ex;
    }

    @Atomic
    public ExemploIdentidade updateExemploIdentidade(final String nome) {
        this.setParam1(nome);
        return this;
    }

    /*
    public java.lang.String getParam1() {
        return super.getParam1();
    }
ss
    public java.lang.String getParam2() {
        return super.getParam2();
    }

    public java.lang.Integer getInt1() {
        return super.getInt1();
    }

    */

    /*
    @Overrides
    public Integer getInt1() {
        return this.getInt1();
    }

    @Override
    public String getParam1() {
        return this.getParam1();
    }

    @Override
    public String getParam2() {
        return this.getParam2();
    }

    */


}
