package ligue;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Palmares {

  private int defaite;
  private int victoire;
  private int egalite;

  public void misAJourDefaite() {
    this.defaite++;
  }

  public void misAJourVictoire() {
    this.victoire++;
  }

  public void misAJourEgalite() {
    this.egalite++;
  }
}
