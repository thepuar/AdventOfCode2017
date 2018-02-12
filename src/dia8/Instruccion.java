/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dia8;

/**
 *
 * @author thepu
 */
public class Instruccion {
    String nombrereg1;
    String operacion;
    String nombrereg2;
    String condicion;
    int valoranyadir;
    int valoracomparar;
    
    public Instruccion(String nombrereg1, String operacion,int valoranayadir,String nombrereg2, String condicion,int valoracomparar){
        this.nombrereg1 = nombrereg1;
        this.operacion = operacion;
        this.valoranyadir = valoranayadir;
        this.nombrereg2 = nombrereg2;
        this.condicion = condicion;
        this.valoracomparar = valoracomparar;
    }
    
    public Registro ejecuta(Registro reg1,Registro reg2){
        switch(condicion){
            case "<":
                if(reg2.getValue() < this.valoracomparar){
                    System.out.println(" Se cumple");
                    if(operacion.equals("inc"))reg1.value += this.valoranyadir;
                    else reg1.value -= this.valoranyadir;
                    }
                else System.out.println(" No se cumple ");
                break;
            case ">":
                 if(reg2.getValue() > this.valoracomparar){
                    System.out.println(" Se cumple");
                    if(operacion.equals("inc"))reg1.value += this.valoranyadir;
                    else reg1.value -= this.valoranyadir;
                    }
                else System.out.println(" No se cumple ");
                break;
            case "==":
                 if(reg2.getValue() == this.valoracomparar){
                    System.out.println(" Se cumple");
                    if(operacion.equals("inc"))reg1.value += this.valoranyadir;
                    else reg1.value -= this.valoranyadir;
                    }
                else System.out.println(" No se cumple ");
                break;
            case ">=":
                if(reg2.getValue() >= this.valoracomparar){
                    System.out.println(" Se cumple");
                    if(operacion.equals("inc"))reg1.value += this.valoranyadir;
                    else reg1.value -= this.valoranyadir;
                    }
                else System.out.println(" No se cumple ");
                break;
            case "<=":
                if(reg2.getValue() <= this.valoracomparar){
                    System.out.println(" Se cumple");
                    if(operacion.equals("inc"))reg1.value += this.valoranyadir;
                    else reg1.value -= this.valoranyadir;
                    }
                else System.out.println(" No se cumple ");
                break;
            case  "!=":
                if(reg2.getValue() != this.valoracomparar){
                    System.out.println(" Se cumple");
                    if(operacion.equals("inc"))reg1.value += this.valoranyadir;
                    else reg1.value -= this.valoranyadir;
                    }
                else System.out.println(" No se cumple ");
                break;
            default:
                System.out.println("Esta operacion no esta contemplada "+condicion);
        }
    
    return reg1;
    }
    
    public String getNombreReg2(){
        return this.nombrereg2;
    }
    public String getNombreReg1(){
        return this.nombrereg1;
    }
    
}
