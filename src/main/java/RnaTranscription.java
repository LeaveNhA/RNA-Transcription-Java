import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

class Dna{
    protected String nucleotide = "";

    public Dna(char nucleotide){
        this.nucleotide = Character.toString(nucleotide);
    }

    public Dna(String nucleotide){
        this.nucleotide = nucleotide;
    }

    public String getNucleotide(){
        return this.nucleotide;
    }
}

class Rna{
    protected String nucleotide = "";

    public Rna(Dna dna){
        String tempNucleotide = "";

        switch(dna.getNucleotide())
            {
            case "G":
                tempNucleotide = "C";
                break;

            case "C":
                tempNucleotide = "G";
                break;

            case "T":
                tempNucleotide = "A";
                break;

            case "A":
                tempNucleotide = "U";
                break;

            }
        this.nucleotide = tempNucleotide;
    }

    public String getNucleotide(){
        return this.nucleotide;
    }
}

class RnaTranscription {

    String transcribe(String dnaStrand) {
        List<String> dnaStrand_ = new Vector<String>();

        for(String s : dnaStrand.split(""))
            dnaStrand_.add(s);

        List<String> rna = dnaStrand_.stream()
            .map( nucleotide -> new Dna(nucleotide) )
            .map( dna -> new Rna(dna) )
            .map( rna_ -> rna_.getNucleotide() )
            .collect(Collectors.toList());

        return String.join("", rna);
    }
}
