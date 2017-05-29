 
import java.util.*;
import java.io.*;
import static java.lang.System.out;
import Exceptions.*;


public class Main implements Serializable{
    private Core core = new Core();
    private Persistencia state = new Persistencia();
    int decisao;
    private Scanner inputMain = new Scanner(System.in).useDelimiter("\\n");

    /**
     * A função run é responsável por executar o primeiro menu (login/registo).
     */
    public void run(){
        boolean flag = true;

        while(flag){
            out.println("-----------GeocachingPOO----------");
            out.println("1 - Registar utilizador");
            out.println("2 - Login");
            out.println("3 - Exit");
            out.println("----------------------------------");
            out.print("Decisão: " );

            try{
                decisao = inputMain.nextInt();

                switch(decisao){
                    case 1:
                        core.registarUser();
                        break;

                    case 2:
                        if(core.login()==1){
                            afterLogin();
                        }
                        break;

                    case 3:
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
            }catch(SexoInvalidoException e){
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
    public void afterLogin(){
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
            out.println("5 - Lista utilizadores");
            out.println("6 - Remover conta");
            if(core.isAdmin()) {
                out.println("7 - Carregar estado");
                out.println("8 - Guardar estado"); }
            out.println("9 - Exit");
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
                            core = state.carregarEstado();
                            out.println("Estado carregado com sucesso, por favor faça login de novo!\n");
                            flag=false;
                        }else
                            throw new PrivilegiosInsuficientesException();

                        break;

                    case 8:
                        if(core.isAdmin()){
                            state.guardarEstado(core);
                            out.println("Estado guardado com sucesso!\n");
                        }else
                            throw new PrivilegiosInsuficientesException();

                        break;

                    case 9:
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
                afterLogin();
            }catch(CacheNaoExisteException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(AtividadeJaDescobertaException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(DataInvalidaException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(SolucaoErradaException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(TesouroInvalidoException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(AtividadeNullException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(DificuldadeInvalidaException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(PrivilegiosInsuficientesException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(AmigoJaAdicionadoException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(UtilizadorNaoExisteException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(AdicionarMesmaPessoaException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(PedidoNaoExisteException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(EventoNaoExisteException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(JaInscritoEventoException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(InscricoesCheiasException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(PassouDataLimiteException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(CacheJaInseridaException e){
                out.println(e.getMessage());
                flag=false;
                afterLogin();
            }catch(NaoExistemParticipantesException e){
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
}