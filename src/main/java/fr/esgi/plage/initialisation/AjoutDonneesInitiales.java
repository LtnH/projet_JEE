package fr.esgi.plage.initialisation;

import fr.esgi.plage.business.*;
import fr.esgi.plage.dao.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

    private final FileDao fileDao;

    private final ParasolDao parasolDao;

    private final LienDeParenteDao lienDeParenteDao;

    private final PaysDao paysDao;

    private final StatutDao statutDao;

    private final ClientDao clientDao;

    @Override
    public void run(String... args) throws Exception {
        Pays france = new Pays("fr", "France");
        LienDeParente lienNull = new LienDeParente("cousin/cousine", 0.25f);

        if (fileDao.count() == 0) {
            fileDao.save(new File(1, 50.00));
            fileDao.save(new File(2, 43.00));
            fileDao.save(new File(3, 36.00));
            fileDao.save(new File(4, 29.00));
            fileDao.save(new File(5, 22.00));
            fileDao.save(new File(6, 15.00));
            fileDao.save(new File(7, 8.00));
        }

        if (parasolDao.count() == 0) {
            for (int i = 1; i < 8; i++) {
                for (int y = 1; y < 9; y++) {
                    parasolDao.save(new Parasol((byte)y, fileDao.findByNumero((byte)i)));
                }
            }
        }

        if (lienDeParenteDao.count() == 0) {
            lienDeParenteDao.save(new LienDeParente("frère/soeur", 0.50f));
            lienDeParenteDao.save(lienNull);
            lienDeParenteDao.save( new LienDeParente("aucun", 0.0f));
        }

        if (paysDao.count() == 0) {
            paysDao.save(france);
            paysDao.save(new Pays("it", "Italie"));
            paysDao.save(new Pays("uk", "Angleterre"));
            paysDao.save(new Pays("es", "Espagne"));
            paysDao.save(new Pays("ch", "suisse"));
        }

        if (statutDao.count() == 0) {
            statutDao.save(new Statut("à traiter"));
            statutDao.save(new Statut("confirmée"));
            statutDao.save(new Statut("refusée"));
        }

        if (clientDao.count() == 0) {
            Client client = new Client();
            client.setMdp("frd123");
            client.setNom("titi");
            client.setPrenom("tata");
            client.setEmail("tata@gmail.com");
            client.setPays(france);
            client.setLienDeParente(lienNull);
            client.setDateHeurInscription(LocalDateTime.now());
            clientDao.save(client);

            Client client2 = new Client();
            client2.setMdp("frd123");
            client2.setNom("titi");
            client2.setPrenom("tata");
            client2.setEmail("tata@gmail.com");
            client2.setPays(france);
            client2.setLienDeParente(lienNull);
            client2.setDateHeurInscription(LocalDateTime.now());
            clientDao.save(client2);
        }
    }
}
