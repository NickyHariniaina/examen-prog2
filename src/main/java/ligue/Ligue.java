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
}
