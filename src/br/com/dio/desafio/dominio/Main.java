package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Curso curso = new Curso();
        curso.setTitulo("Desenvolvimento de aplicações com Java");
        curso.setDescricao("Aprenda a desenvolver aplicações Java");
        curso.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Desenvolvimento de aplicações com C#");
        curso2.setDescricao("Aprenda a desenvolver aplicações C#");
        curso2.setCargaHoraria(10);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Aprendendo Java");
        mentoria.setDescricao("Aprenda Java com quem sabe");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("GFT START #2 Java");
        bootcamp.setDescricao("Bootcamp para formação Java");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devDanyel = new Dev();
        devDanyel.setNome("Danyel");
        devDanyel.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Danyel: " + devDanyel.getConteudosInscritos());
        System.out.println("--------------------");
        devDanyel.progredir();
        devDanyel.progredir();
        System.out.println("Conteúdos concluídos Danyel: " + devDanyel.getConteudosConcluidos());
        System.out.println("Conteúdos inscritos Danyel: " + devDanyel.getConteudosInscritos());
        System.out.println("XP total Danyel: " + devDanyel.calcularTotalXP());

        System.out.println("--------------------");

        Dev devDudu = new Dev();
        devDudu.setNome("Dudu");
        devDudu.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Dudu: " + devDudu.getConteudosInscritos());
        System.out.println("--------------------");
        devDudu.progredir();
        System.out.println("Conteúdos concluídos Dudu: " + devDudu.getConteudosConcluidos());
        System.out.println("Conteúdos inscritos Danyel: " + devDanyel.getConteudosInscritos());
        System.out.println("XP total Dudu: " + devDudu.calcularTotalXP());
    }
}
