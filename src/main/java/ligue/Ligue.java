package ligue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Ligue {

  private final String nom;
  private List<Combattant> combattants = new ArrayList<>();
  private List<Match> matchs = new ArrayList<>();

  public boolean ajouterNouveauCombattant(Combattant combattant) {
    if (combattants.contains(combattant)) {
      return false;
    }
    combattants.add(combattant);
    return true;
  }

  public boolean creerMatch(Match match) {
    if (matchs.contains(match)) {
      return false;
    }
    matchs.add(match);
    return true;
  }

  public List<Match> matchFaitPar(Combattant combattant) {
    return matchs.stream().filter(m -> {
      return m.getCombattant1().equals(combattant) || m.getCombattant2().equals(combattant);
    }).collect(Collectors.toList());
  }

  public boolean terminerUnMatch(Match match, Combattant gagnant, Combattant perdant, String titre) {
    switch (match.getTypeMatch()) {
      case AMICAL:
        return true;
      case OFFICIEL:
        gagnant.misAJourPalmares(true, false);
        perdant.misAJourPalmares(false, false);
        return true;
      case COMPETITIF:
        gagnant.misAJourPalmares(true, false);
        perdant.misAJourPalmares(false, false);
        gagnant.ajouterTitre(titre);
        return true;
      default:
        return false;
    }
  }

  public boolean terminerUnMatch(Match match) {
    switch (match.getTypeMatch()) {
      case AMICAL:
        return true;
      case OFFICIEL:
        match.getCombattant2().misAJourPalmares(true, true);
        match.getCombattant1().misAJourPalmares(true, true);
        return true;
      case COMPETITIF:
        match.getCombattant1().misAJourPalmares(true, true);
        match.getCombattant2().misAJourPalmares(true, true);
        return true;
      default:
        return false;
    }
  }

}
