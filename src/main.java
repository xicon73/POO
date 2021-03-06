 
import java.util.*;
import java.io.*;
import static java.lang.System.out;
import Exceptions.*;


public class Main implements Serializable{
    private static Core core = new Core();
    private static int decisao;
    private static Scanner inputMain = new Scanner(System.in).useDelimiter("\\n");

    /**
     * A função run é responsável por executar o primeiro menu (login/registo).
     */
    public static void run(){
        boolean flag = true;

        while(flag){
            out.println("-----------UMer----------");
            out.println("1 - Registar utilizador");
            out.println("2 - Registar motorista");
            out.println("3 - Login");
            out.println("0 - Exit");
            out.println("----------------------------------");
            out.print("Decisão: " );

            try{
                decisao = inputMain.nextInt();

                switch(decisao){
                    case 1:
                        core.registarUser();
                        break;
                    case 2:
                        core.registarDriver();
                        break;
                    case 3:
                        if(core.login()==1){
                            afterLogin();
                        }
                        break;
                    case 0:
                        flag=false;
                        break;

                    default:
                        throw new SelecaoInvalidaException();
                }
            }catch(InputMismatchException e){
                out.println("Verifique se introduziu um número!");
                flag=false;
            }catch(SelecaoInvalidaException e){
                out.println(e.getMessage());
                flag=false;
                run();
            }catch(EmailInvalidoException e){
                out.println(e.getMessage());
                flag=false;
                run();
            }catch(NomeInvalidoException e){
                out.println(e.getMessage());
                flag=false;
                run();
            }catch(EmailJaExisteException e){
                out.println(e.getMessage());
                flag=false;
                run();
            }catch(DataInvalidaException e){
                out.println(e.getMessage());
                flag=false;
                run();
            }catch(NumberFormatException e){
                out.println(e.getMessage());
                flag=false;
                run();
            }catch(Exception e){
                out.println("Exception geral?");
                flag=false;
                run();
            }
            out.print("\n");
        }
    }

    /**
     * A função afterLogin é responsável por executar o segundo menu, após login com sucesso.
     */
    public static void afterLogin(){
        boolean flag = true;

        while(flag){
            if(core.isAdmin()) out.println("\n-----------UMer: Área de admin ---------");
            else if(core.isDriver()) out.println("\n---------UMer: Área de motoristas");
            else out.println("\n-----------UMer: Área de membros---------");
            out.println("-----------------Bem vindo " + core.getCurrentUser().getNome() + "----------------");
            out.println("1 - Efetuar Viagem");
            out.println("2 - Verificar Histórico de Viagens");
            out.println("3 - Consultar estatisticas");
            out.println("4 - Definições de conta");
            out.println("5 - Lista de utilizadores");
            out.println("6 - Remover conta");
            if(core.isDriver()) {
                out.println("7 - Alterar estado");
                out.println("8 - Registar Viatura");
                out.println("9 - Associar-se a uma Viatura");
                out.println("10 - Desassociar-se de uma Viatura");
            }
            if(core.isAdmin()) {
                out.println("7 - Remover Viatura");
                out.println("8 - Carregar estado");
                out.println("9 - Guardar estado"); }
            out.println("0 - Exit");
            out.println("----------------------------------");
            out.print("Decisão: " );

            try{
                decisao = inputMain.nextInt();
                out.print("\n");
                switch(decisao){
                    case 1:
                        core.fazerViagem();
                        break;

                    case 2:
                        core.historicoViagens();
                        break;

                    case 3:
                        core.consultarEstatisticas();
                        break;

                    case 4:
                        core.definicoesConta();
                        break;

                    case 5:
                        core.listaUsers();
                        break;

                    case 6:
                        if(core.removeUser()) flag=false;
                        break;

                    case 7:
                        if(core.isAdmin()){
                            core.removerViatura();
                            out.println("Viatura removida com sucesso!\n");
                        }else if(core.isDriver()){
                            core.alterarEstado();
                        }else
                            throw new PrivilegiosInsuficientesException();

                        break;

                    case 8:
                        if(core.isAdmin()){
                            core = Persistencia.carregarEstado();
                            out.println("Estado carregado com sucesso, por favor faça login de novo!\n");
                            flag=false;
                        }else if(core.isDriver()){
                            core.registarViatura();
                        }else
                            throw new PrivilegiosInsuficientesException();

                        break;

                    case 9:
                        if(core.isAdmin()){
                            Persistencia.guardarEstado(core);
                            out.println("Estado guardado com sucesso!\n");
                        }else if(core.isDriver()){
                            core.associarViatura();
                        }else throw new PrivilegiosInsuficientesException();
                        break;

                    case 10:
                        if(core.isDriver()){
                            core.desassociarViatura();
                        } else throw new PrivilegiosInsuficientesException();
                        break;

                    case 0:
                        flag=false;
                        break;

                    default:
                        throw new SelecaoInvalidaException();

                }
            }catch(InputMismatchException e){
                out.println("Verifique se introduziu alguma coisa!");
                flag=false;
                afterLogin();
            }catch(SelecaoInvalidaException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(DataInvalidaException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(PrivilegiosInsuficientesException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(UtilizadorNaoExisteException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }/*catch(MotoristasOcupadosException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }*/catch(SemViagensException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(ViagemCanceladaException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(ViaturaNaoExisteException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(ViaturaJaExisteException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(NaoTemViaturaException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(JaTemViaturaException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(Exception e){
                out.println("Exception geral?");
                flag=false;
                afterLogin();
            }
        }
    }
    
    public static void main() {
        run();
        out.println("Sair!");
    }
}