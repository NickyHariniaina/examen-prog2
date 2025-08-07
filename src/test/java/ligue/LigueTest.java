package ligue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LigueTest {

  @Test
  void doit_ajouter_un_match() {

    Ligue ligue = new Ligue("UFC", new ArrayList<Combattant>(), new ArrayList<Match>());

    Combattant combattant1 = new Combattant("001", "Doe", "John", "JohnDoe", 60.56, new ArrayList<String>(),
        new Palmares());

    Combattant combattant2 = new Combattant("002", "Doen", "Johny", "JohnyDo", 75.00, new ArrayList<String>(),
        new Palmares());

    Match match1 = new Match("001", LocalDate.of(2025, 5, 12), "Mahamasine", combattant1, combattant2,
        TypeMatch.AMICAL);

    ligue.ajouterNouveauCombattant(combattant1);
    ligue.ajouterNouveauCombattant(combattant2);
    ligue.creerMatch(match1);

    Assertions.assertEquals(1, ligue.getMatchs().size());
    Assertions.assertEquals(match1, ligue.getMatchs().get(1));
  }

  @Test
  void doit_ajouter_un_combattant() {

    Ligue ligue = new Ligue("UFC", new ArrayList<Combattant>(), new ArrayList<Match>());

    Combattant combattant1 = new Combattant("001", "Doe", "John", "JohnDoe", 60.56, new ArrayList<String>(),
        new Palmares());

    Combattant combattant2 = new Combattant("002", "Doen", "Johny", "JohnyDo", 75.00, new ArrayList<String>(),
        new Palmares());

    ligue.ajouterNouveauCombattant(combattant1);
    ligue.ajouterNouveauCombattant(combattant2);

    Assertions.assertEquals(combattant1, ligue.getCombattants().get(0));
    Assertions.assertEquals(combattant2, ligue.getCombattants().get(1));
    Assertions.assertEquals(2, ligue.getCombattants().size());
  }

  @Test
  void doit_afficher_match_de_combattant() {
    Ligue ligue = new Ligue("UFC", new ArrayList<Combattant>(), new ArrayList<Match>());

    Combattant combattant1 = new Combattant("001", "Doe", "John", "JohnDoe", 60.56, new ArrayList<String>(),
        new Palmares());

    Combattant combattant2 = new Combattant("002", "Doen", "Johny", "JohnyDo", 75.00, new ArrayList<String>(),
        new Palmares());

    Combattant combattant3 = new Combattant("003", "Doez", "Johny", "JohnDeep", 61.72, new ArrayList<String>(),
        new Palmares());

    Combattant combattant4 = new Combattant("004", "Do", "Johnas", "JohnasDo", 85.00, new ArrayList<String>(),
        new Palmares());

    Match match1 = new Match("001", LocalDate.of(2025, 5, 12), "Mahamasina", combattant1, combattant2,
        TypeMatch.AMICAL);

    Match match2 = new Match("002", LocalDate.of(2025, 5, 13), "Mahamasina", combattant1, combattant4,
        TypeMatch.AMICAL);

    Match match3 = new Match("003", LocalDate.of(2025, 5, 13), "Mahamasina", combattant2, combattant4,
        TypeMatch.AMICAL);

    Match match4 = new Match("004", LocalDate.of(2025, 5, 13), "Mahamasina", combattant2, combattant4,
        TypeMatch.AMICAL);

    ligue.creerMatch(match1);
    ligue.creerMatch(match2);
    ligue.creerMatch(match3);
    ligue.creerMatch(match4);

    Assertions.assertEquals(List.of(match2, match3, match4), ligue.matchFaitPar(combattant4));
    Assertions.assertEquals(List.of(match1, match2), ligue.matchFaitPar(combattant1));
    Assertions.assertEquals(0, ligue.matchFaitPar(combattant3).size());
  }
}
