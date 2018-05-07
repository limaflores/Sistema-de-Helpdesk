package entidade;

import entidade.Status;
import entidade.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-23T20:54:00")
@StaticMetamodel(Chamados.class)
public class Chamados_ { 

    public static volatile SingularAttribute<Chamados, String> nome;
    public static volatile SingularAttribute<Chamados, Long> id;
    public static volatile SingularAttribute<Chamados, Usuarios> usuarios;
    public static volatile SingularAttribute<Chamados, Status> status;

}