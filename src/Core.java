
import java.util.*;
import static java.lang.System.out;
import Exceptions.*;
import java.io.*;

/**
 * Class Core, contem todas as funcoes necessarias para o projeto
 *
 * @author Claudia Marques
 * @author Francisco Costa
 * @author Mauricio Salgado
 *
 */





public class Core implements Serializable {
    private TreeMap<String, Cliente> utilizadores = new TreeMap<String, Cliente>();
    private TreeMap<String, Viatura> viaturas = new TreeMap<String, Viatura>();
    private TreeMap<GregorianCalendar, Viagem> viagens = new TreeMap<GregorianCalendar, Viagem>();
    private TreeMap<String, Motorista> motoristas = new TreeMap<String, Motorista>();
    static Scanner input = new Scanner(System.in).useDelimiter("\\n");

    Cliente admin = new Cliente("admin@umer.pt", "1234", "Administrador", "Portugal", new GregorianCalendar(2000, 1, 1), 2);
    Cliente currentUser = new Cliente();
    Motorista currentDriver = new Motorista();

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
    public Cliente getCurrentUser() {
        return currentUser.clone();
    }
    
    public Motorista getCurrentDriver(){
        return currentDriver.clone();}

    // -----BEFORE LOGIN--------
    /**
     * A função registarUser regista um Utilizador.
     */
    public void registarUser() throws EmailInvalidoException,EmailJaExisteException, NomeInvalidoException, DataInvalidaException {
        for (int i = 0; i < 100; i++) out.println();

        Cliente cliente = new Cliente();
        String email, pw, nome, morada, data;
        String[] dataSplit;
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
            cliente = new Cliente(email, pw, nome, morada, nascimento);
        }else
            throw new DataInvalidaException();

        utilizadores.put(cliente.getEmail(), cliente);
        out.println("Registado com sucesso!\n");
    }

    public void registarDriver() throws EmailInvalidoException,EmailJaExisteException, NomeInvalidoException, DataInvalidaException {
        for (int i = 0; i < 100; i++) out.println();

        Motorista motorista = new Motorista();
        String email, pw, nome, morada, data;
        String[] dataSplit;
        int dia, mes, ano;

        out.println("------Registo de motorista------");
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
            motorista = new Motorista(email, pw, nome, morada, nascimento,1,0.f,0,0,0,0);
        }else
            throw new DataInvalidaException();

        utilizadores.put(motorista.getEmail(), motorista);
        motoristas.put(motorista.getEmail(), motorista);
        out.println("Motorista registado com sucesso!\n");
    }

    // case 2 before login
    /**
     * A função login faz o login de um Utilizador.
     */
    public int login() {
        for (int i = 0; i < 100; i++) out.println();
        int valor = 0;
        String email, pw;
        //Utilizador user = new Utilizador();

        out.println("------Login------");
        out.print("Introduza email:  ");
        email = input.next();
        out.print("Introduza password:  ");
        pw = input.next();

        if (utilizadores.containsKey(email) && utilizadores.get(email).getPassword().equals(pw)) {
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


    public void fazerViagem() throws MotoristasOcupadosException, ViagemCanceladaException {
        for (int i = 0; i < 100; i++) out.println();
        String cliente = currentUser.getEmail();
        GregorianCalendar data = new GregorianCalendar();
        String posicao;
        String [] posicaoSplit;
        String condutor = "";
        Coordenadas origem = new Coordenadas();
        Coordenadas destino = new Coordenadas();
        double distancia = 0;
        String viatura;
        double km = 0;
        char confirmacao;
        int pessoas = 1;
        Viagem viagem = new Viagem();
        double tempo = 0;
        double velocidade = 0;
        double custo = 0;
        double aux = 0;
        Coordenadas viaturaO = new Coordenadas();
       


        out.println("-----------UMer: Fazer Viagem---------");

        out.print("Introduza a sua posição (x,y): ");
        posicao = input.next();
        posicaoSplit = posicao.split(",");
        origem.setX(Integer.parseInt(posicaoSplit[0]));
        origem.setY(Integer.parseInt(posicaoSplit[1]));
        viagem.setOrigem(origem);

        out.print("Introduza o seu destino (x,y): ");
        posicao = input.next();
        posicaoSplit = posicao.split(",");
        destino.setX(Integer.parseInt(posicaoSplit[0]));
        destino.setY(Integer.parseInt(posicaoSplit[1]));
        viagem.setDestino(destino);


        distancia = origem.getDistancia(destino);
        km = distancia;
        viagem.setDistancia(distancia);
        out.print("Introduza o número de ocupantes na viagem: ");
        pessoas = input.nextInt();

        out.println("-----------UMer: Lista de motoristas disponíveis---------");
        TreeMap<String, Viatura> viaturasLivres = new TreeMap<String, Viatura>();
        for(Viatura v : viaturas.values()){
            for(Motorista m : motoristas.values()){
                if(v.getCondutor().equals(m.getEmail()) && m.getEstado()==1){
                    viaturasLivres.put(m.getEmail(),v.clone());
                    out.println("Viatura: " + v.getId() + "Condutor : " + v.getCondutor());
                }
            }
        }
        out.print("Selecione a viatura desejada.");
        viatura = input.next();
        viagem.setViatura(viatura);
        for(Viatura v : viaturas.values()){
            if(v.equals(viatura)) {
                viaturaO=v.getLocalizacao();
                velocidade=v.getVelocidade();
                custo=v.getPreco_base();
                condutor=v.getCondutor();
            }
        }
        custo = custo * distancia;
        distancia = viaturaO.getDistancia(origem);
        km += distancia;
        tempo = distancia/velocidade;
        out.println("A viatura está a" + distancia + "km e demora" + tempo + "minutos a chegar!");
        tempo=km/velocidade;
        out.println("A sua viagem demorará" + tempo + "minutos e terá um custo de" + custo + "euros! Aceita? (Y/N)");
        confirmacao=input.next().charAt(0);

        if(confirmacao=='Y') {
            viagem.setPreco(custo);
            viagem.setTempoPrevisto(tempo);
            viagens.put(data, viagem);
            double avaliacao;
            out.print("Avalie a prestação do motorista: ");
            avaliacao=input.nextInt();
            for(Motorista m : motoristas.values()){
                if(m.getEmail().equals(condutor)) {
                    double aT = m.getAvaliacao() * m.getViagens();
                    int viagens = m.getViagens() + 1;
                    m.setAvaliacao((aT + avaliacao) / (viagens));
                    m.setViagens(viagens);
                }
            }
            for(Viatura v : viaturas.values()){
                if(v.getId().equals(viatura)){
                v.setLocalizacao(destino);}
            }
            for(Cliente c : utilizadores.values()){
                if(c.getEmail().equals(currentUser.getEmail())) {
                double money = c.getDespesa() + custo;
                c.setDespesa(money);}
            }
            //dá a nota ao motorista
            //adiciona a viagem aos utilizadores
            //adiciona distancia à viatura e motorista
            //atualiza a posiçao da viatura

        }
        else {throw new ViagemCanceladaException();}
    }


  public void historicoViagens() throws SemViagensException,UtilizadorNaoExisteException,SelecaoInvalidaException{
        String utilizador;
        char opcao;
        int i = 1;
        out.println("----------UMer: Histórico de Viagens ----------");
        if(currentUser.getAdmin()==1) {
            out.print("Deseja procurar o histórico de um cliente ou motorista? (C/M)");
            opcao=input.next().charAt(0);
            if(opcao=='C') {
                out.println("Introduza o email do cliente: ");
                utilizador = input.next();
                if(!utilizadores.containsKey(utilizador)) { throw new UtilizadorNaoExisteException();}
                for(Viagem v : viagens.values()) {
                    if(v.getCliente().equals(utilizador)) {
                        if(i<11){
                            out.println(i + ". O utilizador" + v.getCliente() + "fez uma viagem de " + v.getDistancia() + "km.");
                            i++;
                        }
                    }
                }

            }
            else if(opcao=='M'){
                out.println("Introduza o email do motorista: ");
                utilizador = input.next();
                if(!utilizadores.containsKey(utilizador)) { throw new UtilizadorNaoExisteException();}
                for(Viagem v : viagens.values()) {
                    if(v.getMotorista().equals(utilizador)) {
                        if(i<11){
                            out.println(i + ". O motorista" + v.getMotorista() + " fez uma viagem de " + v.getDistancia() + "km.");
                            i++;
                        }
                    }
                }
            }
            else { throw new SelecaoInvalidaException();}
        }
        else utilizador = currentUser.getEmail();
        if(currentUser.getAdmin()==1) {
            for(Viagem v : viagens.values()) {
                if(v.getMotorista().equals(utilizador)) {
                    if(i<11) {
                        out.println(i + ". O utilizador" + v.getMotorista() + "com" + v.getDistancia() + "kms");
                        i++;
                    }
                }
            }
        }
        else {
            for(Viagem v : viagens.values()) {
                if(v.getCliente().equals(utilizador)) {
                    if(i<11) {
                        out.println(i + ". O utilizador" + v.getCliente() + "com" + v.getDistancia() + "kms");
                        i++;
                    }
                }
            }
        }
    }
    public void consultarEstatisticas() throws ViaturaNaoExisteException, SelecaoInvalidaException{
        int opcao;
        double km = 0;
        String cliente;
        String motorista;
        out.println("----------UMer: Estatísticas --------");
        out.println("1 - Motorista com mais kms");
        out.println("2 - Melhor Cliente");
        out.println("3 - Viatura com mais km");
        out.println("4 - Top 10 utilizadores");
        out.println("5 - Faturação Viatura");
        opcao = input.nextInt();
        switch(opcao) {
            case 1:
            String motorista2 = "";
                double max = 0;
                for(Motorista m : motoristas.values()){ 
                    if(m.getKms()>max) {max=m.getKms();motorista2=m.getEmail();}
                }
                out.println("O melhor motorista é o " + motorista2 + "com um total de " + max + "kms!");
                break;

            case 2:
            String cliente2 = "";
            max=0;
                for(Cliente c : utilizadores.values()){
                    if(c.getDespesa()>max) {max=c.getDespesa(); cliente2 = c.getEmail();}
                }
                out.println("O melhor cliente é o " + cliente2 + "com um total de " + max + "euros gastos!");
                break;

            case 3:
                String viatura6 = "";
                km = 0;
                for(Viatura v : viaturas.values()){
                    if(v.getKms()>km){km=v.getKms(); viatura6 = v.getId();}
                }
                out.println("A viatura com mais km é a viatura com id: " + viatura6 + "com um total de " + km + "kms!");
                break;
            case 4:
                break;
            case 5:
                String viatura5;
                double valor = 0;
                out.print("Introduza o identificador da viatura: ");
                viatura5 = input.next();
                if(viaturas.containsKey(viatura5)) {
                    for(Viagem v : viagens.values()) {
                        if(v.getViatura().equals(viatura5)) {
                            valor += v.getPreco();
                        }
                    }
                    out.println("A viatura" + viatura5 + "faturou" + valor + "euros!");
                } else {throw new ViaturaNaoExisteException();}
                break;
        }
    }
    
    public void alterarEstado(){
        int estado;
        out.println("-----------UMer: Alterar Estado---------");
        out.print("Introduza o seu estado (0 - Fora de serviço, 1 - Livre, 2 - Em viagem)");
        estado = input.nextInt();
        currentDriver.setEstado(estado);
        for(Motorista m : motoristas.values()) {if (m.getEmail().equals(currentDriver.getEmail())) {m.setEstado(estado);}}
    }


    public void registarViatura() throws JaTemViaturaException, ViaturaJaExisteException, SelecaoInvalidaException {
        for (int i = 0; i < 100; i++)out.println();
        int tipo,qualidade, velocidade, preco;
        String criador;
        String id;
        char aux;
        Boolean f = true;
        Viatura viaturaNova = new Viatura();

        out.println("------Registo de viatura------");
        out.println("1 - Carrinha de 9 lugares");
        out.println("2 - Carro Ligeiro");
        out.println("3 - Mota");
        out.println("0 - Sair");
        out.println("-----------------------------");

        while (f) {
            out.print("Selecione o tipo de viatura que pretende registar: ");
            tipo = input.nextInt();
            out.print("Deseja associar esta nova viatura a si? (Y/N)");
            aux=input.next().charAt(0);
            if(aux=='Y') {if(currentDriver.getCarro() == 1) {throw new JaTemViaturaException();}
            else criador = currentDriver.getEmail();}
            /*else*/criador = "";

            out.print("Introduza o identificador da viatura: ");
            id=input.next();
            if(viaturas.containsKey(id)) {throw new ViaturaJaExisteException();}
            //check if is unica
            
          
            switch (tipo) {
                case 1:
                    viaturaNova.setId(id);
                    viaturaNova.setCapacidade(8);
                    viaturaNova.setCondutor(criador);
                    out.print("Introduza a qualidade da viaturaNova: ");
                    qualidade = input.nextInt();
                    viaturaNova.setQualidade(qualidade);
                    out.print("Introduza a velocidade da viaturaNova: ");
                    velocidade = input.nextInt();
                    viaturaNova.setVelocidade(velocidade);
                    out.print("Introduza o preco da viaturaNova: ");
                    preco = input.nextInt();
                    viaturaNova.setPreco_base(preco);
                    // Registar a viatura
                    viaturas.put(id, viaturaNova);
                    f = false;
                    break;

                case 2:
                    viaturaNova.setId(id);
                    viaturaNova.setCapacidade(4);
                    viaturaNova.setCondutor(criador);
                    out.print("Introduza a qualidade do Carro: ");
                    qualidade = input.nextInt();
                    viaturaNova.setQualidade(qualidade);
                    out.print("Introduza a velocidade do Carro: ");
                    velocidade = input.nextInt();
                    viaturaNova.setVelocidade(velocidade);
                    out.print("Introduza o preco do Carro: ");
                    preco = input.nextInt();
                    viaturaNova.setPreco_base(preco);
                    // Registar a viatura
                    viaturas.put(id, viaturaNova);
                    f = false;
                    break;

                case 3:
                    viaturaNova.setId(id);
                    viaturaNova.setCapacidade(1);
                    viaturaNova.setCondutor(criador);
                    out.print("Introduza a qualidade da Mota: ");
                    qualidade = input.nextInt();
                    viaturaNova.setQualidade(qualidade);
                    out.print("Introduza a velocidade da Mota: ");
                    velocidade = input.nextInt();
                    viaturaNova.setVelocidade(velocidade);
                    out.print("Introduza o preco da Mota: ");
                    preco = input.nextInt();
                    viaturaNova.setPreco_base(preco);
                    // Registar a viatura
                    viaturas.put(id, viaturaNova);
                    f = false;
                    break;
                case 0:
                    f = false;
                    break;

                default:
                    throw new SelecaoInvalidaException();
            }
        }
    }


    public void associarViatura() throws JaTemViaturaException, ViaturaNaoExisteException {
        String viatura;
        if(currentDriver.getCarro() == 1) {throw new JaTemViaturaException();}
        out.println("------Associação de uma viatura------");
        out.print("Indique o identificador da viatura a qual pretende associar-se: ");
        viatura = input.next();
        if(viaturas.containsKey(viatura)) {
            for(Viatura v : this.viaturas.values()){
                if(v.getId().equals(viatura)) {
                    currentDriver.setCarro(1);
                    v.setCondutor(currentDriver.getEmail());
                }
            }
        }
        else {throw new ViaturaNaoExisteException();}
        }

    public void desassociarViatura() throws NaoTemViaturaException {
        char opcao;
        if(currentDriver.getCarro() == 0) {throw new NaoTemViaturaException();}
        out.println("------Remoção de viatura------");
        out.println("Tem a certeza de que deseja remover a sua viatura? (Y/N)");
        opcao = input.next().charAt(0);
        if(opcao == 'Y') {
            currentDriver.setCarro(0);
            for(Viatura v : this.viaturas.values()){
                if(v.getCondutor().equals(currentUser.getEmail())) {
                    v.setCondutor("");
                    //Retira o motorista à viatura
                }
            }
        }
    }

    public void removerViatura() throws ViaturaNaoExisteException {
        String viatura;
        String motorista;
        out.println("------Remoção de viatura------");
        out.print("Indique o id da viatura a remover: ");
        viatura = input.next();
        if(viaturas.containsKey(viatura)) {
            for(Viatura v : this.viaturas.values()){
                if(v.getId().equals(viatura)) {
                    motorista=v.getCondutor();
                    if(!(motorista.equals(""))) {
                        for(Motorista m : this.motoristas.values()){
                            if(m.getEmail().equals(motorista)) {
                                m.setCarro(0);
                            }
                        }
                    }
                    viaturas.remove(viatura);
                }
            }
        } else {throw new ViaturaNaoExisteException(); }
    }

    public void definicoesConta() throws PrivilegiosInsuficientesException, SelecaoInvalidaException,DataInvalidaException, UtilizadorNaoExisteException {
        for (int i = 0; i < 100; i++)out.println();
        Boolean v = true;

        out.println("-----------UMer: Definições de conta---------");
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
                    out.println("\n-----------UMer: Alterar password---------");
                    out.print("Introduza password nova: ");
                    currentUser.setPassword(input.next());
                    out.println("Sucesso!");
                    out.println("----------------------\n");
                    v = false;
                    break;

                case 2:
                    out.println("\n-----------UMer: Alterar data de nascimento---------");
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
                    out.println("\n-----------UMer: Alterar morada---------");
                    out.print("Introduza morada nova: ");
                    currentUser.setMorada(input.next());
                    out.println("Sucesso!");
                    out.println("----------------------\n");
                    v = false;
                    break;

                case 4:
                    if (isAdmin()) {
                        out.println("\n-----------UMer: Alterar privilegios---------");
                        Cliente c = new Cliente();
                        out.print("Introduza o email do utilizador: ");
                        c = utilizadores.get(input.next());
                        if (c != null) {
                            out.print("Introduza o novo grau de privilegios do utilizador (0 normal/1 admin): ");
                            c.setAdmin(input.nextInt());
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
     * A função listaUsers verifica a lista de utilizadores.
     */
    public void listaUsers() {
        for (int i = 0; i < 100; i++) out.println();

        out.println("-----------UMer: Lista de utilizadores---------");
        for (Cliente cliente : utilizadores.values()) {
            out.println("Cliente : " + cliente.getNome() + " - " + cliente.getEmail());
        }
        for(Motorista motorista : motoristas.values()){
            out.println("Motorista : " +motorista.getNome() + " - " + motorista.getEmail());
        }
        out.println("----------------------------------------------------");
        out.println("Existem " + utilizadores.size() + " utilizadores no sistema UMer");
        out.println("----------------------------------------------------");
    }

    /**
     * A função removeUser permite ao Utilizador decidir se quer ou não remover a sua conta.
     */
    public boolean removeUser() throws UtilizadorNaoExisteException, PrivilegiosInsuficientesException{
        for (int i = 0; i < 100; i++) out.println();
        char decisao;

        out.println("-----------UMer: Apagar conta---------");
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
            String utilizador = input.next();
            if (!utilizadores.containsKey(utilizador))
                throw new UtilizadorNaoExisteException();
            else {
                /*for(Cliente c : utilizadores.values()){
                    if(c.getEmail().equals(utilizador)) {
                        if(c.getCarro() == 1) {
                            for(Viatura v : viaturas.values()){
                                if(v.getCondutor().equals(utilizador)) {
                                    v.setCondutor("");
                                }
                            }
                        }
                    }
                }*/
                utilizadores.remove(utilizador);
                out.println("Conta removida com sucesso!\n");
                return true;
            }
        }
    }

    public boolean isDriver() {return currentUser.getAdmin()==1;}

    public boolean isAdmin(){
        return currentUser.getAdmin()==2;
    }
}