import java.util.Scanner;
import java.util.ArrayList;

public class Pruebas {
    Scanner s = new Scanner(System.in);

    public void test() {
        int opc = menu();
        while (opc != 5) {
            if (opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5)
                System.out.println("Opción no valida");
            switch (opc) {
                case 1:
                    System.out.println("Ingrese abscisa");
                    double x = s.nextDouble();
                    System.out.println("Infrese ordenada");
                    double y = s.nextDouble();
                    Punto p = new Punto(x, y);
                    int opc1 = menu1();
                    ;
                    while (opc1 != 6) {
                        if (opc1 != 1 && opc1 != 2 && opc1 != 3 && opc1 != 4 && opc1 != 5 && opc1 != 6)
                            System.out.println("Opción no valida");
                        switch (opc1) {
                            case 1:
                                System.out.println("La abscisa del punto es: " + p.x());
                                break;
                            case 2:
                                System.out.println("La ordenada del punto es: " + p.y());
                                break;
                            case 3:
                                System.out.println("El radio polar del punto es: " + p.radio());
                                break;
                            case 4:
                                System.out.println("El ángulo polar de punto es: " + Math.toDegrees(p.angulo()));
                                break;
                            case 5:
                                System.out.println("Ingrese abscisa");
                                double x2 = s.nextDouble();
                                System.out.println("Infrese ordenada");
                                double y2 = s.nextDouble();
                                Punto p1 = new Punto(x2, y2);
                                System.out.println("La distancia euclidiana entre los puntos es: " + p.distancia(p1));
                                break;
                            default:
                                break;
                        }
                        opc1 = menu1();
                    }
                    break;
                case 2:
                    System.out.println("Ingrese dia");
                    byte d = s.nextByte();
                    System.out.println("Ingrese mes");
                    byte m = s.nextByte();
                    System.out.println("Ingrese anyo");
                    int a = s.nextInt();
                    Fechas f = new Fechas(d, m, a);
                    int opc2 = menu2();
                    while (opc2 != 6) {
                        if (opc2 != 1 && opc2 != 2 && opc2 != 3 && opc2 != 4 && opc2 != 5 && opc2 != 6)
                            System.out.println("Opción no valida");
                        switch (opc2) {
                            case 1:
                                System.out.println("El dia es: " + f.dia());
                                break;
                            case 2:
                                System.out.println("El mes es: " + f.meses(f.mes()));
                                break;
                            case 3:
                                System.out.println("El anyo es: " + f.anyo());
                                break;
                            case 4:
                                System.out.println("Ingrese dia");
                                Byte dia2 = s.nextByte();
                                System.out.println("Ingrese mes");
                                Byte mes2 = s.nextByte();
                                System.out.println("Ingrese anyo");
                                int anyo2 = s.nextInt();
                                Fechas f2 = new Fechas(dia2, mes2, anyo2);
                                int c = f.comparar(f2);
                                if (c == 1) {
                                    System.out.println("La fecha " + f + " esta después de el " + f2);
                                } else if (c == 0) {
                                    System.out.println("La fecha " + f + " es igual a " + f2);
                                } else {
                                    System.out.println("La fecha " + f + " esta antes de el " + f2);
                                }
                                break;
                            case 5:
                                System.out.println(f);
                                break;
                            default:
                                break;
                        }
                        opc2 = menu2();
                    }
                    break;
                case 3:
                    System.out.println("Ingrese abscisa");
                    double x3d = s.nextDouble();
                    System.out.println("Infrese ordenada");
                    double y3d = s.nextDouble();
                    System.out.println("Infrese cota");
                    double z3d = s.nextDouble();
                    Punto3D p3d = new Punto3D(x3d, y3d, z3d);
                    int opc3 = menu3();
                    while (opc3 != 8) {
                        if (opc3 != 1 && opc3 != 2 && opc3 != 3 && opc3 != 4 && opc3 != 5 && opc3 != 6 && opc3 != 7
                                && opc3 != 8)
                            System.out.println("Opción no valida");
                        switch (opc3) {
                            case 1:
                                System.out.println("La abscisa del punto es: " + p3d.x());
                                break;
                            case 2:
                                System.out.println("La ordenada del punto es: " + p3d.y());
                                break;
                            case 3:
                                System.out.println("La cota del punto es: " + p3d.z());
                                break;
                            case 4:
                                System.out.println("El radio polar del punto es: " + p3d.radio());
                                break;
                            case 5:
                                System.out
                                        .println("El angulo polar del punto es: " + Math.toDegrees(p3d.anguloPolar()));
                                break;
                            case 6:
                                System.out.println(
                                        "El angulo acimut del punto es: " + Math.toDegrees(p3d.anguloAcimut()));
                                break;
                            case 7:
                                System.out.println("Ingrese abscisa");
                                double x3d2 = s.nextDouble();
                                System.out.println("Infrese ordenada");
                                double y3d2 = s.nextDouble();
                                System.out.println("Infrese cota");
                                double z3d2 = s.nextDouble();
                                System.out.println("La distancia euclidiana entre los puntos es: "
                                        + p3d.distancia(new Punto3D(x3d2, y3d2, z3d2)));
                                break;
                            default:
                                break;
                        }
                        opc3 = menu3();
                    }
                    break;
                case 4:
                    System.out.println("Ingrese abscisa del punto incicial");
                    double xl = s.nextDouble();
                    System.out.println("Infrese ordenada del punto incicial");
                    double yl = s.nextDouble();
                    System.out.println("Ingrese abscisa del punto final");
                    double xlf = s.nextDouble();
                    System.out.println("Infrese ordenada del punto final");
                    double ylf = s.nextDouble();
                    Linea2D l = new Linea2D(new Punto(xl, yl), new Punto(xlf, ylf));
                    int opc4 = menu4();
                    while (opc4 != 4) {
                        if (opc4 != 1 && opc4 != 2 && opc4 != 3 && opc4 != 4)
                            System.out.println("Opción no valida");
                        switch (opc4) {
                            case 1:
                                System.out.println("El punto inicial es: " + l.pi());
                                break;
                            case 2:
                                System.out.println("El punto final es: " + l.pf());
                                break;
                            case 3:
                                System.out.println(
                                        "La pendiente es: " + l.pendiente() + "\n Los puntos intermedios son: ");
                                ArrayList<Punto> ps = l.puntos();
                                for (int i = 0; i < ps.size(); i++) {
                                    System.out.println(ps.get(i));
                                }
                                break;
                            default:
                                break;
                        }
                        opc4 = menu4();
                    }
                default:
                    break;
            }
            opc = menu();
        }
        System.out.println();
        System.out.println("GRACIAS POR CUIDARSE  \ud83d\ude37  \ud83d\ude37  \ud83d\ude37");
    }

    public int menu() {
        System.out.println("Datos abstractos");
        System.out.println("(1) - Puntos");
        System.out.println("(2) - Fechas");
        System.out.println("(3) - Punto3D");
        System.out.println("(4) - Linea2D");
        System.out.println("(5) - Salir");
        return s.nextInt();
    }

    public int menu1() {
        System.out.println("Puntos");
        System.out.println("(1) - Obtener abscisa");
        System.out.println("(2) - Obtener ordenada");
        System.out.println("(3) - Conocer radio polar");
        System.out.println("(4) - Conocer ángulo polar");
        System.out.println("(5) - Distancia euclidiana con otro punto");
        System.out.println("(6) - Regresar");
        return s.nextInt();
    }

    public int menu2() {
        System.out.println("Fechas");
        System.out.println("(1) - Obtener dia");
        System.out.println("(2) - Obtener mes");
        System.out.println("(3) - Obtener anyo");
        System.out.println("(4) - Realizar comparación");
        System.out.println("(5) - Imprimir fecha");
        System.out.println("(6) - Regresar");
        return s.nextInt();
    }

    public int menu3() {
        System.out.println("Puntos 3D");
        System.out.println("(1) - Obtener abscisa");
        System.out.println("(2) - Obtener ordenada");
        System.out.println("(3) - Obtener cota");
        System.out.println("(4) - Conocer radio polar");
        System.out.println("(5) - Conocer ángulo polar");
        System.out.println("(6) - Conocer ángulo acimut");
        System.out.println("(7) - Distancia euclidiana con otro punto");
        System.out.println("(8) - Regresar");
        return s.nextInt();
    }

    public int menu4() {
        System.out.println("Linea 2D");
        System.out.println("(1) - Obtener punto inicial");
        System.out.println("(2) - Obtener punto final");
        System.out.println("(3) - Obtener puntos intermedios");
        System.out.println("(4) - Regresar");
        return s.nextInt();
    }
}