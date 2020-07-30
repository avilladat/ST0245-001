public class Fechas {
    private int dia;
    private int mes;
    private int anyo;

    public Fechas(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    public int dia(){
        return this.dia;
    }

    public int mes(){
        return this.mes;
    }

    public int anyo(){
        return this.anyo;
    }

    public String toString() {
        return this.dia+" de "+meses(this.mes)+" del "+this.anyo;
    }

    public int comparar(Fechas f){
        if((this.dia>f.dia() && this.mes==f.mes() && this.anyo==f.anyo())||
            (this.dia==f.dia() && this.mes>f.mes() && this.anyo==f.anyo())||
            (this.dia!=f.dia() && this.mes>f.mes() && this.anyo==f.anyo())||
            (this.dia==f.dia() && this.mes==f.mes() && this.anyo>f.anyo())||
            (this.dia!=f.dia() && this.mes!=f.mes() && this.anyo>f.anyo())||
            (this.dia!=f.dia() && this.mes==f.mes() && this.anyo>f.anyo())||
            (this.dia==f.dia() && this.mes!=f.mes() && this.anyo>f.anyo())){
            return 1;
        }else if(this.dia==f.dia() && this.mes==f.mes() && this.anyo==f.anyo()){
            return 0;
        }else{
            return -1;
        } 
    }

    public String meses(int a){
        switch(a){
            case 1:
            return "Enero";
            case 2:
            return "Febrero";
            case 3:
            return "Marzo";
            case 4:
            return "Abril";
            case 5:
            return "Mayo";
            case 6:
            return "Junio";
            case 7:
            return "Julio";
            case 8:
            return "Agosto";
            case 9:
            return "Septiembre";
            case 10:
            return "Octubre";
            case 11:
            return "Noviembre";
            case 12:
            return "Diciembre";
            default:
            return "Mes no valido";
        }
    }
}