import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Universidade univ = new Universidade();

        Date ent = new Date(1,8,2017);
        Date sai = new Date(1,8,2024);
        Aluno aluno = new Aluno("Ivan", "10525602", ent, "EngComp", 4, new ArrayList<String>(), sai);

        Date ent1 = new Date(1,8,1997);
        Professor profA = new Professor("Carlos", "129132", ent1, 10000, 30, "doutor", "Computação", "3B00", "robótica");
        Geral geralProfA = new Geral("Carlos", "129132", ent1, 10000, 30, "professor", true);
        Date ent2 = new Date(1,8,1998);
        Professor profB = new Professor("Maria", "122312", ent2, 10000, 30, "doutor", "Matemática", "3B00", "algebra");
        Geral geralProfB = new Geral("Maria", "122312", ent2, 10000, 30, "professora", true);

        univ.addPessoa(aluno);
        univ.addPessoa(profA);
        univ.addPessoa(profB);
        univ.addPessoa(geralProfA);
        univ.addPessoa(geralProfB);

        System.out.println(univ.periodoIdeal("10525602"));
    }
}
