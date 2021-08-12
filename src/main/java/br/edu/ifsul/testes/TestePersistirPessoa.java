package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPessoa {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabPrimeiraEtapa-ModeloPU");
        EntityManager em = emf.createEntityManager();
        Pessoa p = new Pessoa();
        p.setNome("Pedro Marchetti Casteli");
        p.setCpf("00000000000");
        p.setRg("0000000000");
        p.setEmail("nome@nome.com");
        p.setTelefone("54999998888");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
