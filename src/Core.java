 

import java.util.*;
import static java.lang.System.out;
import Exceptions.*;
import java.io.*;

/**
 * Class Core, contem todas as funcoes necessarias para o projeto
 *
 * @author Octavio Maia
 * @author Cecilia Marciel
 * @author Claudia Marques
 * @version 1.0
 */
public class Core implements Serializable {
    private TreeMap<String, Utilizador> utilizadores = new TreeMap<String, Utilizador>();
    private TreeMap<String, Cache> caches = new TreeMap<String, Cache>();
    private TreeMap<String, Cache> reportedCaches = new TreeMap<String, Cache>();
    private TreeMap<String, Evento> eventos = new TreeMap<String, Evento>();
    static Scanner input = new Scanner(System.in).useDelimiter("\\n");

    Utilizador admin = new Utilizador("admin", "123", "Administrador", 'M',"Portugal", new GregorianCalendar(2000, 1, 1), 1);
    Utilizador currentUser = new Utilizador();
    Cache cache1 = new Cache("Octávio Maia", new Coordenadas(1, 1), 2,"Procurem pela arvore mais alta", null);

    /**
     * Construtor vazio.
     */
    public Core() {
        // inserir admin
        utilizadores.put(admin.getEmail(), admin);
    }

    /**
     * A função getCurrentUser devolve um Utilizador.
     */
    public Utilizador getCurrentUser() {
        return currentUser.clone();
    }

    // -----BEFORE LOGIN--------
    /**
     * A função registarUser regista um Utilizador.
     */
    public void registarUser() throws EmailInvalidoException,EmailJaExisteException, NomeInvalidoException,SexoInvalidoException, DataInvalidaException {
        for (int i = 0; i < 100; i++) out.println();

        Utilizador user = new Utilizador();
        String email, pw, nome, morada, data;
        String[] dataSplit;
        char sexo;
        int dia, mes, ano;

        out.println("------Registo de utilizador------");
        out.print("Introduza email:  ");
        email = input.next();

        if (!email.contains("@") || !email.contains("."))
            throw new EmailInvalidoException(); // um email tem de ter um @ e um .

        if (utilizadores.containsKey(email))
            throw new EmailJaExisteException();

        out.print("Introduza password:  ");
        pw = input.next();

        out.print("Introduza nome:  ");
        nome = input.next();

        if (nome.matches("[0-9]+"))
            throw new NomeInvalidoException(); // o nome de uma pessoa nao pode ter numeros

        out.print("Introduza morada:  ");
        morada = input.next();

        out.print("Introduza sexo: (M/F) ");
        sexo = input.next().charAt(0);

        if (sexo != 'F' && sexo != 'M')
            throw new SexoInvalidoException();

        out.print("Introduza data de nascimento: (Dia/Mes/Ano) ");
        data = input.next();
        dataSplit = data.split("/");

        try{
            dia = Integer.parseInt(dataSplit[0]);
            mes = Integer.parseInt(dataSplit[1]);
            ano = Integer.parseInt(dataSplit[2]);
        }catch (Exception e) { //nao sei de outra maneira de o fazer
            throw new DataInvalidaException();
        }

        if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && String.valueOf(ano).length() == 4) {
            GregorianCalendar nascimento = new GregorianCalendar(ano, mes, dia);
            user = new Utilizador(email, pw, nome, sexo, morada, nascimento, 0);
        }else
            throw new DataInvalidaException();

        utilizadores.put(user.getEmail(), user);
        out.println("Registado com sucesso!\n");
    }

    // case 2 before login
    /**
     * A função login faz o login de um Utilizador.
     */
    public int login() {
        for (int i = 0; i < 100; i++) out.println();
        int valor = 0;
        String email, pw;
        Utilizador user = new Utilizador();

        out.println("------Login------");
        out.print("Introduza email:  ");
        email = input.next();
        out.print("Introduza password:  ");
        pw = input.next();

        if (utilizadores.containsKey(email) && utilizadores.get(email).getPw().equals(pw)) {
            for (int i = 0; i < 100; i++) out.println();
            out.println("Login com sucesso!");
            currentUser = utilizadores.get(email);
            valor = 1;
        } else {
            for (int i = 0; i < 100; i++) out.println();
            out.println("Login sem sucesso!");
            valor = 0;
        }
        return valor;
    }

    // ------------------AFTER LOGIN----------------


    /**
     * A função inserirAtividade insere uma atividade.
     */
    public void fazerViagem() throws MotoristasOcupadosExcepetion, ViagemCanceladaException {
        for (int i = 0; i < 100; i++) out.println();
        Coordenadas origem;
        Coordenadas destino;
        double distancia;
        String viatura;
        char confirmacao;
        TreeMap<String, Viatura> viaturasLivres = getLivres();
        if(viaturasLivres.size()==0) {
            out.println("Não existem motoristas disponíveis!");
            catch MotoristasOcupadosException;
        }
        out.println("-----------UMer: Fazer Viagem---------");
        out.print("Introduza a sua posição: ");
        origem = input.next();
        out.print("Introduza o seu destino: ");
        destino = input.next();
        out.println("-----------UMer: Lista de motoristas disponíveis---------");
        for (Map.Entry<String, Utilizador> entry : utilizadores.entrySet()) {
            out.println(entry.getValue().toString(entry.getValue()));
        }
        out.print("Selecione a viatura desejada.");
        viatura = input.next();
        //distancia = getDistancia(viatura,origem);
        out.println("A viatura está a" + distancia + "km e demora" + tempo + "minutos a chegar!");
        //distancia = getDistancia(origem,destino);
        out.println("A sua viagem demorará" + tempo + "minutos e terá um custo de" + custo + "euros! Aceita? (Y/N)");
        confirmacao=input.next().charAt(0);

        if(confirmacao==Y) {
            int avaliacao;
            //adiciona a viagem aos utilizadores
            //adiciona distancia à viatura e motorista
            //atualiza a posiçao da viatura
            out.print("Avalie a prestação do motorista: ");
            avaliacao=input.next();
            //dá a nota ao motorista
        }
        else {catch ViagemCanceladaException;}
    }


    /**
     * A função registarCache regista uma cache.
     */
    public void registarViatura() throws {
        for (int i = 0; i < 100; i++)out.println();
        int tipo,qualidade, velocidade, preco;
        String criador, descricao;
        Coordenadas coord = new Coordenadas();
        Boolean f = true;
        criador = currentUser.getNome();

        out.println("------Registo de viatura------");
        out.println("1 - Carrinha de 9 lugares");
        out.println("2 - Carro Ligeiro");
        out.println("3 - Mota");
        out.println("4 - Sair");
        out.println("-----------------------------");

        while (f) {
            out.print("Selecione o tipo de viatura que pretende registar: ");
            tipo = input.nextInt();
            switch (tipo) {
                case 1:
                    Carrinha viatura1 = new Carrinha();
                    out.print("Introduza a qualidade da Carrinha: ");
                    qualidade = input.nextInt();
                    out.print("Introduza a velocidade da Carrinha: ");
                    velocidade = input.nextInt();
                    out.print("Introduza o preco da Carrinha: ");
                    preco = input.nextInt();
                    // Registar a viatura
                    caches.put(cache1.getCodigo(), cache1);
                    out.println(cache1.getTipo() + " adicionada com sucesso!\n");
                    f = false;
                    break;

                case 2:
                    Carro viatura2 = new Carro();

                    out.println("Criador: " + criador);
                    cache2.setCriador(criador);

                    caches.put(cache2.getCodigo(), cache2);
                    out.println(cache2.getTipo() + " adicionada com sucesso!\n");
                    f = false;
                    break;

                case 3:
                    Mota viatura3 = new Mota();

                    caches.put(cache3.getCodigo(), cache3);
                    out.println(cache3.getTipo() + " adicionada com sucesso!\n");
                    f = false;
                    break;
                case 4:
                    f = false;
                    break;

                default:
                    throw new SelecaoInvalidaException();
            }
        }
    }

    /**
     * A função removerCache remove uma cache.
     */
    public void removerCache() throws PrivilegiosInsuficientesException,CacheNaoExisteException {
        for (int i = 0; i < 100; i++) out.println();
        String codigo;

        out.println("-----------GeocachingPOO: Remoção de cache---------");
        out.print("Introduza o codigo da cache a remover: ");
        codigo = input.next();

        if (isAdmin() || (currentUser.getNome().equals(caches.get(codigo).getCriador()))) {
            if (caches.get(codigo) == null)
                throw new CacheNaoExisteException();
            else {
                caches.remove(codigo); // se a cache existe, remove!
                if (reportedCaches.get(codigo) != null)
                    reportedCaches.remove(codigo); // se esta cache estava  reportada removemos tambem
                out.println("Removido com sucesso!");
            }
        }else{
            throw new PrivilegiosInsuficientesException();
        }
    }

    /**
     * A função reportarCache verifica se um Utilizador encontra uma anomalia na cache, e caso isso aconteça reporta a cache.
     */
    public void reportarCache() throws CacheNaoExisteException {
        for (int i = 0; i < 100; i++) out.println();
        String codigo2, motivo;

        out.println("-----------GeocachingPOO: Report abuse---------");
        out.print("Introduza o codigo da cache a reportar: ");
        codigo2 = input.next();

        if(caches.get(codigo2)==null) throw new CacheNaoExisteException();
        else{
            out.print("Introduza o motivo do report: ");
            motivo = input.next();

            caches.get(codigo2).setReportMotive(motivo);
            reportedCaches.put(codigo2, caches.get(codigo2));
            out.println("Reportado com sucesso!");
        }
    }


    /**
     * A função consultaAtividades permite ao Utilizador consultar a atividade de uma cache.
     */
    public void consultaAtividades() throws UtilizadorNaoExisteException,  AtividadeNullException {
        for (int i = 0; i < 100; i++) out.println();
        String user;
        int i = 0;

        out.println("-----------GeocachingPOO: Consulta de atividades---------");
        out.print("Email do utilizador a consultar: ");
        user = input.next();

        if (utilizadores.containsKey(user)) {
            Utilizador userTemp = utilizadores.get(user);
            if (userTemp.getAtividades().size() == 0) {
                throw new AtividadeNullException();
            } else {
                for (GregorianCalendar entry : userTemp.getAtividades().descendingKeySet()) {
                    if (i < 10) {
                        out.println("Cache nº"+ (userTemp.getAtividades().size() - i));
                        out.println("\tTipo Cache: " + userTemp.getAtividades().get(entry).getTipo());
                        out.println("\tCódigo Cache: " + userTemp.getAtividades().get(entry).getCodigo());
                        out.println("\tDescoberta em: " + entry.get(Calendar.DAY_OF_MONTH) + "/"
                                + entry.get(Calendar.MONTH) + "/"
                                + entry.get(Calendar.YEAR) + "\n");
                        i++;
                    }
                }
            }
        }else
            throw new UtilizadorNaoExisteException();
    }

    /**
     * A função estatisticasUser verifica as estatísticas referentes a um Utilizador.
     */
    public void estatisticasUser() throws UtilizadorNaoExisteException,AtividadeNullException,DataInvalidaException{
        for (int i = 0; i < 100; i++) out.println();
        String User;
        int normal = 0, micro = 0, evento = 0, virtual = 0, multi = 0, misterio = 0;
        int anoPesquisa, mesPesquisa = 0;

        out.println("-----------GeocachingPOO: Estatisticas---------");
        out.print("Introduza o email do utilizador que pretender verificar: ");
        User = input.next();

        if (utilizadores.containsKey(User)) {
            Utilizador UserTemp = utilizadores.get(User);
            if (UserTemp.getAtividades().size() == 0) {
                throw new AtividadeNullException();
            } else {
                out.print("Introduza o ano que pretende verificar (0 -> estatisticas globais): ");
                anoPesquisa = input.nextInt();
                if (String.valueOf(anoPesquisa).length() != 4 && anoPesquisa!=0) throw new DataInvalidaException();

                if (anoPesquisa != 0) {
                    out.print("Introduza o mês que pretende verificar (0 -> todos os meses desse ano): ");
                    mesPesquisa = input.nextInt();
                    if(mesPesquisa<0 || mesPesquisa>12 ) throw new DataInvalidaException();
                }
                if (anoPesquisa == 0) {
                    for (Map.Entry<GregorianCalendar, Cache> cach : UserTemp.getAtividades().entrySet()) {
                        if (cach.getValue().getTipo().equals("Cache Normal")) normal++;
                        if (cach.getValue().getTipo().equals("Micro Cache")) micro++;
                        if (cach.getValue().getTipo().equals("Cache Evento"))evento++;
                        if (cach.getValue().getTipo().equals("Cache Misterio")) misterio++;
                        if (cach.getValue().getTipo().equals("Cache Virtual"))virtual++;
                        if (cach.getValue().getTipo().equals("Multi Cache"))multi++;
                    }
                } else if (String.valueOf(anoPesquisa).length() == 4 && mesPesquisa >= 1 && mesPesquisa <= 12) {
                    for (Map.Entry<GregorianCalendar, Cache> cach : UserTemp.getAtividades().entrySet()) {
                        if (cach.getValue().getTipo().equals("Cache Normal") && cach.getKey().get(Calendar.MONTH) == mesPesquisa && cach.getKey().get(Calendar.YEAR) == anoPesquisa) normal++;
                        if (cach.getValue().getTipo().equals("Micro Cache") && cach.getKey().get(Calendar.MONTH) == mesPesquisa && cach.getKey().get(Calendar.YEAR) == anoPesquisa) micro++;
                        if (cach.getValue().getTipo().equals("Cache Evento")&& cach.getKey().get(Calendar.MONTH) == mesPesquisa && cach.getKey().get(Calendar.YEAR) == anoPesquisa)evento++;
                        if (cach.getValue().getTipo().equals("Cache Misterio") && cach.getKey().get(Calendar.MONTH) == mesPesquisa && cach.getKey().get(Calendar.YEAR) == anoPesquisa) misterio++;
                        if (cach.getValue().getTipo().equals("Cache Virtual") && cach.getKey().get(Calendar.MONTH) == mesPesquisa && cach.getKey().get(Calendar.YEAR) == anoPesquisa) virtual++;
                        if (cach.getValue().getTipo().equals("Multi Cache") && cach.getKey().get(Calendar.MONTH) == mesPesquisa&& cach.getKey().get(Calendar.YEAR) == anoPesquisa)multi++;
                    }
                } else if (String.valueOf(anoPesquisa).length() == 4 && mesPesquisa == 0) {
                    for (Map.Entry<GregorianCalendar, Cache> cach : UserTemp.getAtividades().entrySet()) {
                        if (cach.getValue().getTipo().equals("Cache Normal") && cach.getKey().get(Calendar.YEAR) == anoPesquisa)normal++;
                        if (cach.getValue().getTipo().equals("Micro Cache") && cach.getKey().get(Calendar.YEAR) == anoPesquisa)micro++;
                        if (cach.getValue().getTipo().equals("Cache Evento") && cach.getKey().get(Calendar.YEAR) == anoPesquisa)evento++;
                        if (cach.getValue().getTipo().equals("Cache Misterio") && cach.getKey().get(Calendar.YEAR) == anoPesquisa)misterio++;
                        if (cach.getValue().getTipo().equals("Cache Virtual") && cach.getKey().get(Calendar.YEAR) == anoPesquisa)virtual++;
                        if (cach.getValue().getTipo().equals("Multi Cache")&& cach.getKey().get(Calendar.YEAR) == anoPesquisa)multi++;
                    }
                }
                out.println("-------------------------");
                out.println("O utilizador encontrou o seguinte numero de caches nesse dado periodo:");
                out.println("\tCache Normal: " + normal);
                out.println("\tMicro Cache: " + micro);
                out.println("\tCache Evento: " + evento);
                out.println("\tCache Misterio: " + misterio);
                out.println("\tCache Virtual: " + virtual);
                out.println("\tMulti Cache: " + multi);
                out.println("\nPara um total de " + UserTemp.getPontuacao() + " pontos");
            }
        } else {
            throw new UtilizadorNaoExisteException();
        }
    }

    /**
     * A função definicoesConta permite alterar as definições da conta de um Utilizador.
     */
    public void definicoesConta() throws PrivilegiosInsuficientesException, SelecaoInvalidaException,DataInvalidaException, UtilizadorNaoExisteException {
        for (int i = 0; i < 100; i++)out.println();
        Boolean v = true;

        out.println("-----------GeocachingPOO: Definições de conta---------");
        out.println("1 - Alterar password");
        out.println("2 - Alterar data nascimento");
        out.println("3 - Alterar morada");
        if (isAdmin())  out.println("4 - Alterar privilegios");
        out.println("5 - Exit");
        out.println("----------------------");
        out.print("Decisão: ");
        int decisao = input.nextInt();

        while (v) {
            switch (decisao) {
                case 1:
                    out.println("\n-----------GeocachingPOO: Alterar password---------");
                    out.print("Introduza password nova: ");
                    currentUser.setPw(input.next());
                    out.println("Sucesso!");
                    out.println("----------------------\n");
                    v = false;
                    break;

                case 2:
                    out.println("\n-----------GeocachingPOO: Alterar data de nascimento---------");
                    String[] dataSplit;
                    String data;
                    int dia,mes,ano;

                    out.print("Introduza data de nascimento nova: (Dia/Mes/Ano) ");
                    data = input.next();

                    dataSplit = data.split("/");

                    try {
                        dia = Integer.parseInt(dataSplit[0]);
                        mes = Integer.parseInt(dataSplit[1]);
                        ano = Integer.parseInt(dataSplit[2]);
                    } catch (Exception e) {
                        throw new DataInvalidaException();
                    }

                    if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && String.valueOf(ano).length() == 4) {
                        GregorianCalendar novaData = new GregorianCalendar(ano,mes, dia);
                        currentUser.setDate(novaData);
                        out.println("Sucesso!");
                    } else {
                        throw new DataInvalidaException();
                    }

                    out.println("----------------------\n");
                    v = false;
                    break;

                case 3:
                    out.println("\n-----------GeocachingPOO: Alterar morada---------");
                    out.print("Introduza morada nova: ");
                    currentUser.setMorada(input.next());
                    out.println("Sucesso!");
                    out.println("----------------------\n");
                    v = false;
                    break;

                case 4:
                    if (isAdmin()) {
                        out.println("\n-----------GeocachingPOO: Alterar privilegios---------");
                        Utilizador t = new Utilizador();
                        out.print("Introduza o email do utilizador: ");
                        t = utilizadores.get(input.next());
                        if (t != null) {
                            out.print("Introduza o novo grau de privilegios do utilizador (0 normal/1 admin): ");
                            t.setPrivilegios(input.nextInt());
                            out.println("Sucesso!");
                        } else {
                            v = false;
                            throw new UtilizadorNaoExisteException();
                        }
                        out.println("----------------------\n");
                    }else throw new PrivilegiosInsuficientesException();
                    v = false;
                    break;

                case 5:
                    v = false;
                    break;

                default:
                    throw new SelecaoInvalidaException();
            }
        }
    }

    /**
     * A função listaUsers verifica a lista de Utilizadores.
     */
    public void listaUsers() {
        for (int i = 0; i < 100; i++) out.println();

        out.println("-----------GeocachingPOO: Lista de utilizadores---------");
        for (Map.Entry<String, Utilizador> entry : utilizadores.entrySet()) {
            out.println(entry.getValue().toString(entry.getValue()));
        }
        out.println("----------------------------------------------------");
        out.println("Existem " + utilizadores.size() + " utilizadores no sistema GeocachingPOO");
        out.println("----------------------------------------------------");
    }

    /**
     * A função removeUser permite ao Utilizador decidir se quer ou não remover a sua conta.
     */
    public boolean removeUser() throws UtilizadorNaoExisteException, PrivilegiosInsuficientesException{
        for (int i = 0; i < 100; i++) out.println();
        char decisao;

        out.println("-----------GeocachingPOO: Apagar conta---------");
        if (!isAdmin()) {
            out.print("Tem a certeza que pretende remover a sua conta? (y/n) : ");
            decisao = input.next().charAt(0);

            if (decisao == ('y')) {
                utilizadores.remove(currentUser.getEmail());
                out.println("Conta removida com sucesso!\n");
                return true;
            } else {
                out.println("Abortado");
                return false;
            }
        } else {
            out.print("Introduza o email do utilizador que pretende remover: ");
            String userRemover = input.next();
            if (!utilizadores.containsKey(userRemover))
                throw new UtilizadorNaoExisteException();
            else {
                utilizadores.remove(userRemover);
                out.println("Conta removida com sucesso!\n");
                return true;
            }
        }
    }

    public boolean isDriver() {return currentUser.instanceof(Motorista)}

    public boolean isAdmin(){
        return currentUser.getAdmin()==1;
    }
}