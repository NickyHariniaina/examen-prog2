package ligue;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Combattant {

  private final String idCombattant;
  private final String nom;
  private final String prenom;
  private final String nomCombattant;
  private double poids;
  private List<String> titres = new ArrayList<>();
  private Palmares palmares = new Palmares();

  public boolean misAJourPalmares(boolean aGagne, boolean estEgalite) {
    if (aGagne && !estEgalite) {
      this.palmares.misAJourEgalite();
    } else if (aGagne && estEgalite) {
      this.palmares.misAJourEgalite();
    } else if (!aGagne && !estEgalite) {
      this.palmares.misAJourDefaite();
    } else {
      return false;
    }
    return true;
  }
}
