package ligue;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Match {

  private final String idMatch;
  private LocalDate dateMatch;
  private String endroit;
  private Combattant combattant1;
  private Combattant combattant2;

  public Match(String idMatch, LocalDate dateMatch, String endroit, Combattant combattant1, Combattant combattant2) {
    this.idMatch = idMatch;
    this.dateMatch = dateMatch;
    this.endroit = endroit;
    if (combattant1.equals(combattant2)) {
      throw new IllegalArgumentException("Un combattant ne peut pas s'affrtenter lui meme");
    } else {
      this.combattant1 = combattant1;
      this.combattant2 = combattant2;
    }
  }
}
