import java.util.*;
import java.io.*;
/*
 * Classe que aplica todas as outras, interagindo com o utilizador
 * a partir de menus.
 */
public class Menu
{
    /*private static int estatisticas(GeoCachingPOO gc, String email){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int ano;
        String input;
        Utilizador u = gc.getUtilizador(email);
        TreeMap<Integer,EstatisticasAno> estatisticas = u.getEstatisticas();
        System.out.println("Anos:");
        for(Integer i: estatisticas.keySet()) System.out.println(". "+i+"\t- "+estatisticas.get(i).getTotal()+" caches");
        System.out.println("Insira um ano para ver detalhes (0 para voltar)");
        while(!sc1.hasNextInt()) sc1.nextLine();
        ano = sc1.nextInt();
        while(ano != 0){
            if(!estatisticas.keySet().contains(ano)) System.out.println("Ano inválido");
            else{
                System.out.println(estatisticas.get(ano).toString());
                System.out.println("Prima qualquer tecla para voltar");
                input = sc2.nextLine();
            }
            System.out.println("Anos:");
            for(Integer i: estatisticas.keySet()) System.out.println(". "+i+"\t- "+estatisticas.get(i).getTotal()+" caches");
            System.out.println("Insira um ano para ver detalhes (0 para voltar)");
            while(!sc1.hasNextInt()) sc1.nextLine();
            ano = sc1.nextInt();
        }
        return 0;
    }*/

    /*private static int atividades(GeoCachingPOO gc, String email){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int opcao;
        String input;
        Cache cache;
        Utilizador u = gc.getUtilizador(email);
        ArrayList<Atividade> ativ = u.getAtividades();
        if(ativ.size() == 0) {
            System.out.println("Sem atividades. Prima qualquer tecla para voltar");
            input = sc2.nextLine();
            return 1;
        }
        System.out.println("");
        for(int i = 0; i<ativ.size(); i++){
            cache = gc.getCache(ativ.get(i).getCodigo());
            System.out.println((i+1)+". "+ativ.get(i).toString()+"\t"+cache.getNome());
        }
        System.out.println("0. Voltar");
        while(!sc1.hasNextInt()) sc1.nextLine();
        opcao = sc1.nextInt();
        while(opcao >= 1 && opcao <= 10){
            cache = gc.getCache(ativ.get(opcao-1).getCodigo());
            System.out.println("\n"+cache.toString());
            System.out.println("Prima qualquer tecla para voltar");
            input = sc2.nextLine();
            System.out.println("");
            for(int i = 0; i<ativ.size(); i++){
                cache = gc.getCache(ativ.get(i).getCodigo());
                System.out.println((i+1)+". "+ativ.get(i).toString()+"\t"+cache.getNome());
            }
            System.out.println("0. Voltar");
            while(!sc1.hasNextInt()) sc1.nextLine();
            opcao = sc1.nextInt();
        }
        return 0;
    }*/

    private static int perfil(GeoCachingPOO gc, String email) throws UtilizadorNuloException{
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int opcao;
        String input;
        Utilizador u = gc.getUtilizador(email);
        System.out.println(u.toString());
        System.out.println("\n1. Alterar informações");
        System.out.println("2. Ver estatísticas");
        System.out.println("3. Últimas atividades");
        System.out.println("4. Apagar conta");
        System.out.println("0. Voltar ao menu principal\n");
        while(!sc1.hasNextInt()) sc1.nextLine();
        opcao = sc1.nextInt();
        while(opcao != 0){
            switch(opcao){
                case 1:
                    System.out.println("1. Password");
                    System.out.println("2. Nome");
                    System.out.println("3. Género");
                    System.out.println("4. Morada");
                    System.out.println("5. Data de nascimento");
                    System.out.println("0. Voltar ao perfil");
                    while(!sc1.hasNextInt()) sc1.nextLine();
                    opcao = sc1.nextInt();
                    switch(opcao){
                        case 1:
                            System.out.print("Nova Password: ");
                            input = sc2.nextLine();
                            if(input.equals("")){
                                System.out.println("Password inválida. Dados inalterados");
                                break;
                            }
                            gc.setPassword(email,input);
                            System.out.println("Password alterada para: "+input);
                            break;
                        case 2:
                            System.out.print("Nome: ");
                            input = sc2.nextLine();
                            gc.setNome(email,input);
                            break;
                        case 3:
                            System.out.println("1. Masculino");
                            System.out.println("2. Feminino");
                            System.out.println("3. Não definido");
                            while(!sc1.hasNextInt()) sc1.nextLine();
                            opcao = sc1.nextInt();
                            switch(opcao){
                                case 1:
                                    gc.setGenero(email,Genero.M);
                                    break;
                                case 2:
                                    gc.setGenero(email,Genero.F);
                                    break;
                                case 3:
                                    gc.setGenero(email,Genero.ND);
                                    break;
                            }
                            break;
                        case 4:
                            System.out.print("Morada: ");
                            input = sc2.nextLine();
                            gc.setMorada(email,input);
                            break;
                        case 5:
                            System.out.print("Data de nascimento: ");
                            input = sc2.nextLine();
                            gc.setDataNascimento(email,input);
                            break;
                    }
                    break;
                case 2:
                    estatisticas(gc,email);
                    break;
                case 3:
                    atividades(gc,email);
                    break;
                case 4:
                    System.out.println("Tem a certeza que pretende apagar a sua conta? Esta ação é irreversível. (s/n)");
                    input = sc2.nextLine();
                    if(input.equals("s")){
                        gc.apagarUtilizador(email);
                        throw new UtilizadorNuloException("Conta apagada");
                    }
                    break;
            }
            u = gc.getUtilizador(email);
            System.out.println("\n"+u.toString());
            System.out.println("\n1. Alterar informações");
            System.out.println("2. Ver estatísticas");
            System.out.println("3. Últimas atividades");
            System.out.println("0. Voltar ao menu principal\n");
            while(!sc1.hasNextInt()) sc1.nextLine();
            opcao = sc1.nextInt();
        }
        return 0;
    }

    /*private static int perfilAmigo(GeoCachingPOO gc, String email, String emailAmigo){
        Scanner sc = new Scanner(System.in);
        int opcao;
        Utilizador u = gc.getUtilizador(email);
        Utilizador amigo = gc.getUtilizador(emailAmigo);
        System.out.println("\n"+amigo.toString());
        System.out.println("\n1. Ver estatísticas");
        System.out.println("2. Últimas atividades");
        System.out.println("3. Remover amigo");
        System.out.println("0. Voltar");
        while(!sc.hasNextInt()) sc.nextLine();
        opcao = sc.nextInt();
        while(opcao != 0){
            switch(opcao){
                case 1:
                    estatisticas(gc,emailAmigo);
                    break;
                case 2:
                    atividades(gc,emailAmigo);
                    break;
                case 3:
                    gc.removeAmigo(email,emailAmigo);
                    return 1;
            }
            System.out.println("\n"+amigo.toString());
            System.out.println("\n1. Ver estatísticas");
            System.out.println("2. Últimas atividades");
            System.out.println("3. Remover amigo");
            System.out.println("0. Voltar");
            while(!sc.hasNextInt()) sc.nextLine();
            opcao = sc.nextInt();
        }
        return 0;
    }*/

    /*private static int listaAmigos(GeoCachingPOO gc, String email){
        Scanner sc1 = new Scanner(System.in);
        int opcao;
        String input;
        Utilizador u = gc.getUtilizador(email);
        ArrayList<String> amigos = new ArrayList<String>();
        for(String s: u.getAmigos())amigos.add(s);
        if(amigos.isEmpty()) {
            System.out.println("\nLista de amigos vazia");
            return 1;
        }
        System.out.println("\nLista de amigos:");
        for(int i = 0; i<amigos.size(); i++) System.out.println((i+1)+". "+amigos.get(i));
        System.out.println("0. Voltar");
        while(!sc1.hasNextInt()) sc1.nextLine();
        opcao = sc1.nextInt();
        while(opcao>0){
            opcao--;
            perfilAmigo(gc,email,amigos.get(opcao));

            u = gc.getUtilizador(email);
            amigos = new ArrayList<String>();
            for(String s: u.getAmigos()) amigos.add(s);
            if(amigos.isEmpty()) {
                System.out.println("\nLista de amigos vazia");
                return 1;
            }
            System.out.println("\nLista de amigos:");
            for(int i = 0; i<amigos.size(); i++) System.out.println((i+1)+". "+amigos.get(i));
            System.out.println("0. Voltar");
            while(!sc1.hasNextInt()) sc1.nextLine();
            opcao = sc1.nextInt();
        }
        return 0;
    }

    private static int pedidosAmizade(GeoCachingPOO gc, String email){
        Scanner sc = new Scanner(System.in);
        int opcao;
        Utilizador u = gc.getUtilizador(email);
        ArrayList<String> pedidos = u.getPedidos();
        System.out.println("");
        if(pedidos.size() == 0) System.out.println("Sem pedidos");
        else for(int i = 0;i<pedidos.size();i++) System.out.println((i+1)+". "+pedidos.get(i));
        System.out.println("0. Voltar");
        while(!sc.hasNextInt()) sc.nextLine();
        opcao = sc.nextInt();
        while(opcao > 0){
            opcao--;
            if(opcao < pedidos.size()){
                String emailp = pedidos.get(opcao);
                Utilizador utilp = gc.getUtilizador(emailp);
                if(utilp != null){
                    System.out.println(utilp.toString());
                    System.out.println("\n1. Aceitar");
                    System.out.println("2. Recusar");
                    System.out.println("0. Voltar");
                    while(!sc.hasNextInt()) sc.nextLine();
                    opcao = sc.nextInt();
                    switch(opcao){
                        case 1:
                            gc.addAmigo(email,emailp);
                            gc.removePedido(email,emailp);
                            System.out.println(emailp+" adicionado à lista de amigos.");
                            break;
                        case 2:
                            gc.removePedido(email,emailp);
                            break;
                    }
                }
            }
            System.out.println("");
            u = gc.getUtilizador(email);
            pedidos = u.getPedidos();
            if(pedidos.size() == 0) System.out.println("Sem pedidos");
            else for(int i = 0;i<pedidos.size();i++) System.out.println((i+1)+". "+pedidos.get(i));
            System.out.println("0. Voltar");
            while(!sc.hasNextInt()) sc.nextLine();
            opcao = sc.nextInt();
        }
        return 0;
    }

    private static int menuAmigos(GeoCachingPOO gc, String email){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int opcao;
        Utilizador u = gc.getUtilizador(email);
        int npedidos = u.getPedidos().size();
        String emailp;
        System.out.println("\n1. Lista de amigos");
        System.out.println("2. Pedidos de amizade ("+npedidos+")");
        System.out.println("3. Enviar pedido de amizade");
        System.out.println("0. Voltar ao menu principal");
        while(!sc1.hasNextInt()) sc1.nextLine();
        opcao = sc1.nextInt();
        while(opcao != 0){
            switch(opcao){
                case 1:
                    listaAmigos(gc, email);
                    break;
                case 2:
                    pedidosAmizade(gc, email);
                    break;
                case 3:
                    System.out.println("Insira o email (0 para voltar)");
                    emailp = sc2.nextLine();
                    while(!emailp.equals("0")){
                        if(email.equals(emailp)) System.out.println("Impossível enviar pedido de amizado a si próprio");
                        else{
                            try{
                                gc.addPedido(email,emailp);
                                System.out.println("Pedido enviado para \""+emailp+"\"");
                                break;
                            }
                            catch(UtilizadorNuloException e){
                                System.out.println("O email \""+emailp+"\" não pertence a nenhum utilizador");
                            }
                            catch(UtilizadorExistenteException e){
                                System.out.println("\""+emailp+"\""+" já pertence aos seus amigos");
                            }
                        }
                        System.out.println("Insira o email (0 para voltar)");
                        emailp = sc2.nextLine();
                    }
                    break;
            }
            u = gc.getUtilizador(email);
            npedidos = u.getPedidos().size();
            System.out.println("\n1. Lista de amigos");
            System.out.println("2. Pedidos de amizade ("+npedidos+")");
            System.out.println("3. Enviar pedido de amizade");
            System.out.println("0. Voltar ao menu principal");
            while(!sc1.hasNextInt()) sc1.nextLine();
            opcao = sc1.nextInt();
        }
        return 0;
    }*/

    private static int fazerViagem(UMer um, String email){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Utilizador u = gc.getUtilizador(email);
        int opcao;
        String codigo;
        double latitude, longitude;
        int dificuldade;
        System.out.println("\nEscolha o tipo de cache a criar: ");
        System.out.println("1. Micro-Cache");
        System.out.println("2. Cache Tradicional");
        System.out.println("3. Multi-Cache");
        System.out.println("4. Cache Mistério");
        System.out.println("5. Cache Virtual");
        System.out.println("0. Cancelar");
        while(!sc1.hasNextInt()) sc1.nextLine();
        opcao = sc1.nextInt();
        switch(opcao){
            case 1:
                System.out.println("Criação de Micro-Cache (Insira 0 ou valores inválidos para cancelar)");
                break;
            case 2:
                System.out.println("Criação de Cache Tradicional (Insira 0 ou valores inválidos para cancelar)");
                break;
            case 3:
                System.out.println("Criação de Multi-Cache (Insira 0 ou valores inválidos para cancelar)");
                break;
            case 4:
                System.out.println("Criação de Cache Mistério (Insira 0 ou valores inválidos para cancelar)");
                break;
            case 5:
                System.out.println("Criação de Cache Virtual (Insira 0 ou valores inválidos para cancelar)");
                break;
            default:
                return 1;
        }
        System.out.print("Código: ");
        codigo = sc2.nextLine();
        while(gc.existeCache(codigo)){
            System.out.println("Código inválido");
            System.out.print("Código: ");
            codigo = sc2.nextLine();
        }
        if(codigo.equals("0")){
            System.out.println("Criação cancelada");
            return 1;
        }
        System.out.println("Coordenadas: ");
        System.out.print(" Latitude (-90º até 90º): ");
        while(!sc1.hasNextDouble()) sc1.nextLine();
        latitude = sc1.nextDouble();
        if(latitude < -90 || latitude > 90){
            System.out.println("Valor de latitude inválido. Criação cancelada");
            return 2;
        }
        System.out.print(" Longitude (-180º até 180º): ");
        while(!sc1.hasNextDouble()) sc1.nextLine();
        longitude = sc1.nextDouble();
        if(longitude < -180 || longitude > 180){
            System.out.println("Valor de longitude inválido. Criação cancelada");
            return 3;
        }
        System.out.print("Dificuldade (1 a 10): ");
        while(!sc1.hasNextInt()) sc1.nextLine();
        dificuldade = sc1.nextInt();
        if(dificuldade < 1 || dificuldade > 10){
            System.out.println("Valor inválido; criação cancelada");
            return 4;
        }
        Coordenadas coord = new Coordenadas(latitude,longitude);
        switch(opcao){
            case 1:
                Cache micro = new Cache(codigo,coord,dificuldade,u.getEmail());
                gc.addCriacao(email,micro.clone());
                System.out.println("\nCriação completa");
                System.out.println(micro.toString()+"\nCódigo: "+codigo);
                break;
            case 2:
                String objecto;
                System.out.print("Objecto: ");
                objecto = sc2.nextLine();
                if(objecto.equals("0")){
                    System.out.println("Criação cancelada");
                    return 5;
                }
                CacheTradicional trad = new CacheTradicional(codigo,coord,dificuldade,u.getEmail(),objecto);
                gc.addCriacao(email,trad.clone());
                System.out.println("\nCriação completa");
                System.out.println(trad.toString()+"\nCódigo: "+codigo+"\nObjecto: "+objecto);
                break;
            case 3:
                String pista, codigo_parte;
                System.out.println("Próxima cache da sequência: ");
                System.out.print(" Pista: ");
                pista = sc2.nextLine();
                if(pista.equals("0")){
                    System.out.println("Criação cancelada");
                    return 9;
                }
                System.out.print(" Código: ");
                codigo_parte = sc2.nextLine();
                if(codigo_parte.equals("0")){
                    System.out.println("Criação cancelada");
                    return 10;
                }
                MultiCacheParte parte = new MultiCacheParte(codigo_parte,null);
                MultiCache multi = new MultiCache(codigo,coord,dificuldade,u.getEmail(),pista);
                multi.addCache(parte.clone());
                System.out.println("\nTamanho da sequência: "+multi.getNumCaches());
                System.out.println("1. Completar criação");
                System.out.println("2. Adicionar cache à sequência");
                System.out.println("0. Cancelar");
                while(!sc1.hasNextInt()) sc1.nextLine();
                opcao = sc1.nextInt();
                while(opcao > 0){
                    switch(opcao){
                        case 1:
                            gc.addCriacao(email,multi.clone());
                            System.out.println("\nCriação completa");
                            System.out.println(multi.toString()+"\nCódigo: "+codigo);
                            return 0;
                        case 2:
                            System.out.println("\nPróxima cache da sequência: ");
                            System.out.print(" Pista: ");
                            pista = sc2.nextLine();
                            if(pista.equals("0")) break;
                            System.out.print(" Código: ");
                            codigo_parte = sc2.nextLine();
                            if(codigo_parte.equals("0")) break;
                            MultiCacheParte parte2 = new MultiCacheParte(codigo_parte,null);
                            multi.setPistaIndice(multi.getNumCaches()-2,pista);
                            multi.addCache(parte2.clone());
                            if(multi.getNumCaches() == 5){
                                gc.addCriacao(email,multi.clone());
                                System.out.println("\nCriação completa");
                                System.out.println(multi.toString()+"\nCódigo: "+codigo);
                                return 0;
                            }
                            break;
                        case 0:
                            System.out.println("Criação cancelada");
                            return 11;
                    }
                    System.out.println("\nTamanho da sequência: "+multi.getNumCaches());
                    System.out.println("1. Completar criação");
                    System.out.println("2. Adicionar cache à sequência");
                    System.out.println("0. Cancelar");
                    while(!sc1.hasNextInt()) sc1.nextLine();
                    opcao = sc1.nextInt();
                }
                break;
            case 4:
                String puzzle, solucao;
                System.out.println("Puzzle ou enigma: ");
                puzzle = sc2.nextLine();
                if(puzzle.equals("0") || puzzle.equals("")){
                    System.out.println("Criação cancelada");
                    return 6;
                }
                System.out.print("Solução: ");
                solucao = sc2.nextLine();
                if(solucao.equals("0") || solucao.equals("")){
                    System.out.println("Criação cancelada");
                    return 7;
                }
                CacheMisterio mist = new CacheMisterio(codigo,coord,dificuldade,u.getEmail(),puzzle,solucao);
                gc.addCriacao(email,mist.clone());
                System.out.println("\nCriação completa");
                System.out.println(mist.toString()+"\nCódigo: "+codigo+"\nPuzzle: "+puzzle+"\nSolução: "+solucao);
                break;
            case 5:
                String descricao;
                System.out.print("Descrição do local: ");
                descricao = sc2.nextLine();
                if(descricao.equals("0")){
                    System.out.println("Criação cancelada");
                    return 8;
                }
                CacheVirtual virt = new CacheVirtual(codigo,coord,dificuldade,u.getEmail(),descricao);
                gc.addCriacao(email,virt.clone());
                System.out.println("\nCriação completa");
                System.out.println(virt.toString());
                break;
        }
        return 0;
    }

    private static int historicoViagens(UMer um, String email){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Utilizador u = gc.getUtilizador(email);
        int opcao;
        int i = 1;
        String chave, input;
        Cache cache;
        ArrayList<String> conjchaves = new ArrayList<String>();
        System.out.println("");
        for(String codigo: gc.getCaches().keySet()){
            cache = gc.getCache(codigo);
            if(cache.getEstado() && !u.existeDescoberta(codigo) && !cache.getCriador().equals(email)) {
                conjchaves.add(codigo);
                System.out.println(i+". "+cache.getNome()+" - "+cache.getCoordenadas().toString()+" - Dificuldade: "+cache.getDificuldade());
                i++;
            }
        }
        System.out.println("0. Voltar");
        while(!sc1.hasNextInt()) sc1.nextLine();
        opcao = sc1.nextInt();
        while(opcao > 0 && opcao <= conjchaves.size()){
            chave = conjchaves.get(opcao-1);
            cache = gc.getCache(chave);
            System.out.println("\n"+cache.toString());
            System.out.println("\n1. Inserir código de descoberta");
            System.out.println("2. Report abuse");
            System.out.println("0. Voltar");
            while(!sc1.hasNextInt()) sc1.nextLine();
            opcao = sc1.nextInt();
            if(opcao == 1) {
                switch(cache.getClass().getSimpleName()){
                    case "Cache":
                    case "CacheVirtual":
                        System.out.println("\nInsira código (0 Voltar)");
                        input = sc2.nextLine();
                        while(!input.equals(cache.getCodigo()) && !input.equals("0")){
                            System.out.println("\nCódigo errado");
                            System.out.println("Insira código (0 Voltar)");
                            input = sc2.nextLine();
                        }
                        if(!input.equals("0")){
                            Atividade atv = new Atividade(cache.getCodigo(),"Descoberta");
                            gc.addDescoberta(email,atv.clone());
                            System.out.println("Descoberta registada");
                        }
                        break;
                    case "CacheTradicional":
                        CacheTradicional cachetrad = (CacheTradicional)cache;
                        System.out.println("\nInsira código (0 Voltar)");
                        input = sc2.nextLine();
                        while(!input.equals(cache.getCodigo()) && !input.equals("0")){
                            System.out.println("\nCódigo errado");
                            System.out.println("Insira código (0 Voltar)");
                            input = sc2.nextLine();
                        }
                        if(!input.equals("0")){
                            System.out.print("Encontrou o objecto: "+cachetrad.getObjecto()+"\n");
                            System.out.println("Alterou o objecto? (s/n)");
                            input = sc2.nextLine();
                            if(input.equals("s")){
                                System.out.print("Novo objecto: ");
                                input = sc2.nextLine();
                                gc.setObjecto(cachetrad.getCodigo(),input);
                            }
                            Atividade atv = new Atividade(cache.getCodigo(),"Descoberta");
                            gc.addDescoberta(email,atv.clone());
                            System.out.println("Descoberta registada");
                        }
                        break;
                    case "CacheMisterio":
                        CacheMisterio mist = (CacheMisterio)cache;
                        System.out.println("\nInsira código (0 Voltar)");
                        input = sc2.nextLine();
                        while(!input.equals(cache.getCodigo()) && !input.equals("0")){
                            System.out.println("\nCódigo errado");
                            System.out.println("Insira código (0 Voltar)");
                            input = sc2.nextLine();
                        }
                        if(!input.equals("0")){
                            System.out.println("Puzzle: "+mist.getPuzzle()+" (0 Voltar)");
                            System.out.print("Solução: ");
                            input = sc2.nextLine();
                            while(!input.equals(mist.getSolucao()) && !input.equals("0")){
                                System.out.println("Errado!");
                                System.out.println("Puzzle: "+mist.getPuzzle()+" (0 Voltar)");
                                System.out.print("Solução: ");
                                input = sc2.nextLine();
                            }
                            if(!input.equals("0")){
                                System.out.println("Correcto!");
                                Atividade atv = new Atividade(cache.getCodigo(),"Descoberta");
                                gc.addDescoberta(email,atv.clone());
                                System.out.println("Descoberta registada");
                            }
                        }
                        break;
                    case "MultiCache":
                        MultiCache multi = (MultiCache)cache;
                        System.out.println("\nInsira código (0 Voltar)");
                        input = sc2.nextLine();
                        while(!input.equals(cache.getCodigo()) && !input.equals("0")){
                            System.out.println("\nCódigo errado");
                            System.out.println("Insira código (0 Voltar)");
                            input = sc2.nextLine();
                        }
                        if(!input.equals("0")){
                            int pos = 0;
                            ArrayList<MultiCacheParte> seq = multi.getCaches();
                            String pista = multi.getPista();
                            while(pos < multi.getNumCaches()-2){
                                System.out.println("\nDescobertas "+(pos+1)+" caches de "+multi.getNumCaches());
                                System.out.println("Próxima cache (0 Voltar):");
                                System.out.println(" Pista: "+pista);
                                System.out.print(" Código: ");
                                input = sc2.nextLine();
                                while(!input.equals(seq.get(pos).getCodigo()) && !input.equals("0")){
                                    System.out.println("\nCódigo errado (0 Voltar)");
                                    System.out.println("Próxima cache: ");
                                    System.out.println(" Pista: "+pista);
                                    System.out.print(" Código: ");
                                    input = sc2.nextLine();
                                }
                                if(input.equals("0")) break;
                                pista = seq.get(pos).getPista();
                                pos++;
                            }
                            if(input.equals("0")) break;
                            Atividade atv = new Atividade(cache.getCodigo(),"Descoberta");
                            gc.addDescoberta(email,atv.clone());
                            System.out.println("\nDescoberta registada");
                        }
                        break;
                }
            }
            else if(opcao == 2){
                gc.addReport(chave);
                System.out.println("\nReport enviado.");
            }
            i=1;
            System.out.println("");
            conjchaves = new ArrayList<String>();
            u = gc.getUtilizador(email);
            for(String codigo: gc.getCaches().keySet()){
                cache = gc.getCache(codigo);
                if(cache.getEstado() && !u.existeDescoberta(codigo) && !cache.getCriador().equals(email)) {
                    conjchaves.add(codigo);
                    System.out.println(i+". "+cache.getNome()+" - "+cache.getCoordenadas().toString()+" - Dificuldade: "+cache.getDificuldade());
                    i++;
                }
            }
            System.out.println("0. Voltar");
            while(!sc1.hasNextInt()) sc1.nextLine();
            opcao = sc1.nextInt();
        }
        return 0;
    }

    /*private static int cachesDescobertas(GeoCachingPOO gc, String email){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Utilizador u = gc.getUtilizador(email);
        int opcao;
        String input;
        ArrayList<Atividade> descobertas = new ArrayList<Atividade>();
        for(Atividade a: u.getDescobertas()) descobertas.add(a.clone());
        Cache cache;
        Atividade atv;
        System.out.println("");
        if(descobertas.size() == 0) {
            System.out.println("Sem Descobertas. Prima qualquer tecla para voltar");
            input = sc2.nextLine();
            return 1;
        }
        for(int i = 0; i<descobertas.size(); i++){
            atv = descobertas.get(i);
            cache = gc.getCache(atv.getCodigo());
            System.out.println((i+1)+". "+atv.getDia()+"-"+atv.getMes()+"-"+atv.getAno()+"\t"+cache.getNome()+"\t"+cache.getCoordenadas().toString());
        }
        System.out.println("0. Voltar");
        while(!sc.hasNextInt()) sc.nextLine();
        opcao = sc.nextInt();
        while(opcao >= 1 && opcao <= descobertas.size()){
            opcao--;
            atv = descobertas.get(opcao);
            cache = gc.getCache(atv.getCodigo());
            System.out.println("\n"+cache.toStringDetalhado());
            System.out.println("\n1. Remover Descoberta");
            System.out.println("0. Voltar");
            while(!sc.hasNextInt()) sc.nextLine();
            opcao = sc.nextInt();
            if(opcao == 1){
                gc.removeDescoberta(email,atv.getCodigo(),atv.getAno(),atv.getMes());
                System.out.println("Cache removida das suas descobertas");
            }
            u = gc.getUtilizador(email);
            descobertas = new ArrayList<Atividade>();
            for(Atividade a: u.getDescobertas()) descobertas.add(a.clone());
            System.out.println("");
            if(descobertas.size() == 0) {
                System.out.println("Sem Descobertas. Prima qualquer tecla para voltar");
                input = sc2.nextLine();
                return 1;
            }
            for(int i = 0; i<descobertas.size(); i++){
                atv = descobertas.get(i);
                cache = gc.getCache(atv.getCodigo());
                System.out.println((i+1)+". "+atv.getDia()+"-"+atv.getMes()+"-"+atv.getAno()+"\t"+cache.getNome()+"\t"+cache.getCoordenadas().toString());
            }
            System.out.println("0. Voltar");
            while(!sc.hasNextInt()) sc.nextLine();
            opcao = sc.nextInt();
        }
        return 0;
    }*/

    /*private static int cachesCriadas(GeoCachingPOO gc, String email){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Utilizador u = gc.getUtilizador(email);
        int opcao;
        String input;
        ArrayList<Atividade> criacoes = new ArrayList<Atividade>();
        for(Atividade a: u.getCriacoes()) criacoes.add(a.clone());
        Cache cache;
        Atividade atv;
        System.out.println("");
        if(criacoes.size() == 0) {
            System.out.println("Sem criações. Prima qualquer tecla para voltar");
            input = sc2.nextLine();
            return 1;
        }
        for(int i = 0; i<criacoes.size(); i++){
            atv = criacoes.get(i);
            cache = gc.getCache(atv.getCodigo());
            System.out.println((i+1)+". "+atv.getDia()+"-"+atv.getMes()+"-"+atv.getAno()+"\t"+cache.getNome()+"\t"+cache.getCoordenadas().toString());
        }
        System.out.println("0. Voltar");
        while(!sc.hasNextInt()) sc.nextLine();
        opcao = sc.nextInt();
        while(opcao >= 1 && opcao <= criacoes.size()){
            opcao--;
            atv = criacoes.get(opcao);
            cache = gc.getCache(atv.getCodigo());
            System.out.println("\n"+cache.toStringDetalhado());
            System.out.println("\n1. Desativar cache");
            System.out.println("0. Voltar");
            while(!sc.hasNextInt()) sc.nextLine();
            opcao = sc.nextInt();
            if(opcao == 1){
                gc.removeCriacao(email,atv.getCodigo());
                System.out.println("Cache desativada");
            }
            u = gc.getUtilizador(email);
            criacoes = new ArrayList<Atividade>();
            for(Atividade a: u.getCriacoes()) criacoes.add(a.clone());
            System.out.println("");
            if(criacoes.size() == 0) {
                System.out.println("Sem criações. Prima qualquer tecla para voltar");
                input = sc2.nextLine();
                return 1;
            }
            for(int i = 0; i<criacoes.size(); i++){
                atv = criacoes.get(i);
                cache = gc.getCache(atv.getCodigo());
                System.out.println((i+1)+". "+atv.getDia()+"-"+atv.getMes()+"-"+atv.getAno()+"\t"+cache.getNome()+"\t"+cache.getCoordenadas().toString());
            }
            System.out.println("0. Voltar");
            while(!sc.hasNextInt()) sc.nextLine();
            opcao = sc.nextInt();
        }
        return 0;
    }*/

    private static int reports(GeoCachingPOO gc){
        Scanner sc = new Scanner(System.in);
        int opcao;
        Cache cache;
        ArrayList<String> reports = new ArrayList<String>();
        for(String s: gc.getReports()) reports.add(s);
        if(reports.isEmpty()){
            System.out.println("\nSem reports");
            return 1;
        }
        System.out.println("");
        for(int i = 0; i<reports.size(); i++){
            cache = gc.getCache(reports.get(i));
            System.out.println((i+1)+". "+cache.getNome()+"  "+cache.getCoordenadas().toString());
        }
        System.out.println("0. Voltar");
        while(!sc.hasNextInt()) sc.nextLine();
        opcao = sc.nextInt();
        while(opcao > 0){
            opcao --;
            if(opcao < reports.size()){
                cache = gc.getCache(reports.get(opcao));
                System.out.println("\n"+cache.toStringDetalhado());
                System.out.println("\n1. Ativar");
                System.out.println("2. Remover");
                System.out.println("0. Voltar");
                while(!sc.hasNextInt()) sc.nextLine();
                opcao = sc.nextInt();
                switch(opcao){
                    case 1:
                        gc.removeReport(cache.getCodigo());
                        System.out.println("Cache ativada");
                        break;
                    case 2:
                        gc.removeCache(cache.getCodigo());
                        System.out.println("Cache removida");
                        break;
                }
            }
            reports = new ArrayList<String>();
            for(String s: gc.getReports()) reports.add(s);
            if(reports.isEmpty()){
                System.out.println("\nSem reports");
                return 1;
            }
            System.out.println("");
            for(int i = 0; i<reports.size(); i++){
                cache = gc.getCache(reports.get(i));
                System.out.println((i+1)+". "+cache.getNome()+"  "+cache.getCoordenadas().toString());
            }
            System.out.println("0. Voltar");
            while(!sc.hasNextInt()) sc.nextLine();
            opcao = sc.nextInt();
        }
        return 0;
    }
    /*
    private static int listaCaches(GeoCachingPOO gc){
        Scanner sc = new Scanner(System.in);
        int opcao;
        Cache cache;
        ArrayList<Cache> caches = new ArrayList<Cache>();
        for(Cache c: gc.getCaches().values()){
            if(c.getEstado()) caches.add(c);
        }
        if(caches.isEmpty()){
            System.out.println("\nSem caches");
            return 1;
        }
        System.out.println("");
        for(int i = 0; i<caches.size(); i++){
            cache = caches.get(i);
            System.out.println((i+1)+". "+cache.getNome()+"  "+cache.getCoordenadas().toString());
        }
        System.out.println("0. Voltar");
        while(!sc.hasNextInt()) sc.nextLine();
        opcao = sc.nextInt();
        while(opcao > 0){
            opcao--;
            if(opcao < caches.size()){
                cache = caches.get(opcao);
                System.out.println("\n"+cache.toStringDetalhado()+"\n");
                System.out.println("1. Remover cache");
                System.out.println("0. Voltar");
                while(!sc.hasNextInt()) sc.nextLine();
                opcao = sc.nextInt();
                if(opcao == 1) gc.removeCache(cache.getCodigo());
            }
            caches = new ArrayList<Cache>();
            for(Cache c: gc.getCaches().values()){
                if(c.getEstado()) caches.add(c);
            }
            System.out.println("");
            for(int i = 0; i<caches.size(); i++){
                cache = caches.get(i);
                System.out.println((i+1)+". "+cache.getNome()+"  "+cache.getCoordenadas().toString());
            }
            if(caches.isEmpty()){
                System.out.println("\nSem caches");
                return 1;
            }
            System.out.println("0. Voltar");
            while(!sc.hasNextInt()) sc.nextLine();
            opcao = sc.nextInt();
        }
        return 0;
    }*/

    private static int listaUtilizadores(GeoCachingPOO gc){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int opcao;
        String input;
        Utilizador u;
        ArrayList<String> utilizadores = new ArrayList<String>();
        for(String s: gc.getUtilizadores().keySet()){
            if(!gc.getUtilizador(s).isAdmin()) utilizadores.add(s);
        }
        System.out.println("");
        for(int i = 0; i<utilizadores.size(); i++){
            System.out.println((i+1)+". "+utilizadores.get(i));
        }
        System.out.println("0. Voltar");
        while(!sc.hasNextInt()) sc.nextInt();
        opcao = sc.nextInt();
        while(opcao > 0 && opcao <= utilizadores.size()){
            u = gc.getUtilizador(utilizadores.get(opcao-1));
            System.out.println("\n"+u.toString()+"\n");
            System.out.println("1. Banir utilizador");
            System.out.println("2. Atribuir poderes de adminstrador");
            while(!sc.hasNextInt()) sc.nextLine();
            opcao = sc.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("\nBanir utilizador "+u.getEmail()+" ? (S/N)");
                    input = sc2.nextLine();
                    if(input.toLowerCase().equals("s")){
                        gc.apagarUtilizador(u.getEmail());
                        System.out.println("Utilizador removido");
                    }
                    break;
                case 2:
                    System.out.println("\nAtribuir poderes de adminstrador a "+u.getEmail()+" ? (S/N)");
                    input = sc2.nextLine();
                    if(input.toLowerCase().equals("s")){
                        gc.getUtilizador(u.getEmail()).setAdmin(true);
                        System.out.println("Poderes de administrador atribuidos a "+u.getEmail());
                    }
                    break;
            }
            utilizadores = new ArrayList<String>();
            for(String s: gc.getUtilizadores().keySet()){
                if(!gc.getUtilizador(s).isAdmin()) utilizadores.add(s);
            }
            System.out.println("");
            for(int i = 0; i<utilizadores.size(); i++){
                System.out.println((i+1)+". "+utilizadores.get(i));
            }
            System.out.println("0. Voltar");
            while(!sc.hasNextInt()) sc.nextLine();
            opcao = sc.nextInt();
        }
        return 0;
    }

    private static int menu(GeoCachingPOO gc, String email){
        Scanner sc1 = new Scanner(System.in);
        Utilizador u = gc.getUtilizador(email);
        int opcao;
        System.out.println("\n1. O meu perfil");
        System.out.print("2. Solicitar Viagem ");
        System.out.println("\n3. Ver histórico de viagens");
        System.out.println("4. Caches descobertas");
        System.out.println("5. Caches criadas");
        System.out.println("6. Criar cache");
        if(u.isAdmin()){
            System.out.println("7*. Caches reportadas");
            System.out.println("8*. Lista de caches");
            System.out.println("9*. Lista de utilizadores");
        }
        System.out.println("0. Logout\n");
        while(!sc1.hasNextInt()) sc1.nextLine();
        opcao = sc1.nextInt();
        while(opcao != 0){
            switch(opcao){
                case 1:
                    try{
                        perfil(gc,email);
                    }
                    catch (UtilizadorNuloException e){
                        System.out.println("Conta apagada");
                        return 1;
                    }
                    break;
                case 2:
                    fazerViagem(um,email);
                    break;
                case 3:
                    descobertaCaches(gc,email);
                    break;
                case 4:
                    cachesDescobertas(gc,email);
                    break;
                case 5:
                    cachesCriadas(gc,email);
                    break;
                case 6:
                    criarCache(gc,email);
                    break;
                case 7:
                    if(u.isAdmin()) reports(gc);
                    break;
                case 8:
                    if(u.isAdmin()) listaCaches(gc);
                    break;
                case 9:
                    if(u.isAdmin()) listaUtilizadores(gc);
                    break;
            }
            u = gc.getUtilizador(email);
            System.out.println("\n1. O meu perfil");
            System.out.print("2. Amigos ");
            npedidos = u.getPedidos().size();
            if(npedidos > 0) System.out.print("("+npedidos+" pedidos)");
            System.out.println("\n3. Descoberta de caches");
            System.out.println("4. Caches descobertas");
            System.out.println("5. Caches criadas");
            System.out.println("6. Criar cache");
            if(u.isAdmin()){
                System.out.println("7*. Caches reportadas");
                System.out.println("8*. Lista de caches");
                System.out.println("9*. Lista de utilizadores");
            }
            System.out.println("0. Logout\n");
            while(!sc1.hasNextInt()) sc1.nextLine();
            opcao = sc1.nextInt();
        }
        return 0;
    }

    private static void loginMenu(UMer um){
        int opcao, opcao2;
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Utilizador u;
        Genero genero;
        String email, password, nome, morada, data_nascimento;
        HashMap<String,Utilizador> utilizadores;
        System.out.println("1. Login");
        System.out.println("2. Criar conta");
        System.out.println("0. Sair\n");
        while(!sc1.hasNextInt()) sc1.nextLine();
        opcao = sc1.nextInt();
        while(opcao != 0){
            utilizadores = gc.getUtilizadores();
            switch(opcao){
                case 1:
                    System.out.print("Email: ");
                    email = sc2.nextLine();
                    if(!utilizadores.containsKey(email)){
                        System.out.println("Email não existente");
                        break;
                    }
                    System.out.print("Password: ");
                    password = sc2.nextLine();
                    if(!utilizadores.get(email).getPassword().equals(password)){
                        System.out.println("Password incorrecta");
                        break;
                    }
                    menu(gc,email);
                    break;
                case 2:
                    System.out.println("Nova conta (Insira 0 a qualquer momento para cancelar)");
                    System.out.print("Email: ");
                    email = sc2.nextLine();
                    if(email.equals("0")) break;
                    while(utilizadores.containsKey(email) || !email.contains("@")){
                        System.out.println("Email inválido");
                        System.out.print("Email: ");
                        email = sc2.nextLine();
                        if(email.equals("0")) break;
                    }
                    if(email.equals("0")) break;
                    System.out.print("Password: ");
                    password = sc2.nextLine();
                    while(password.equals("") && !password.equals("0")){
                        System.out.println("Password inválida");
                        System.out.print("Password: ");
                        password = sc2.nextLine();
                    }
                    if(password.equals("0")) break;
                    System.out.print("Nome: ");
                    nome = sc2.nextLine();
                    if(nome.equals("0")) break;
                    System.out.println("Genero:");
                    System.out.println("1. Masculino");
                    System.out.println("2. Feminino");
                    System.out.println("3. ND");
                    while(!sc1.hasNextInt()) sc1.nextLine();
                    opcao2 = sc1.nextInt();
                    switch(opcao2){
                        case 1:
                            genero = Genero.M;
                            break;
                        case 2:
                            genero = Genero.F;
                            break;
                        default:
                            genero = Genero.ND;
                            break;
                    }
                    if(opcao2 == 0) break;
                    System.out.print("Morada: ");
                    morada = sc2.nextLine();
                    if(morada.equals("0")) break;
                    System.out.print("Data de nascimento: ");
                    data_nascimento = sc2.nextLine();
                    if(data_nascimento.equals("0")) break;
                    u = new Utilizador(email,password,nome,genero,morada,data_nascimento);
                    try{
                        gc.addUtilizador(u.clone());
                    }
                    catch (Exception e) {}
                    System.out.println("\nConta criada");
                    System.out.println("Password: " + password + "\n" + u.toString());
                    break;
            }
            System.out.println("\n1. Login");
            System.out.println("2. Criar conta");
            System.out.println("0. Sair\n");
            while(!sc1.hasNextInt()) sc1.nextLine();
            opcao = sc1.nextInt();
        }
    }

    public static void main(String[] args){
        UMer um = new UMer();
        File f = new File("dados.ser");
        if(f.exists() && !f.isDirectory()){
            try{
                FileInputStream fileIn = new FileInputStream("dados.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                um = (UMer)in.readObject();
                in.close();
                fileIn.close();
            }
            catch(IOException i){
                i.printStackTrace();
                Utilizador admin = new Utilizador("admin","admin","",Genero.ND,"","");
                try{
                    um.addUtilizador(admin);
                    um.setAdmin("admin",true);
                }
                catch(Exception e) {}
            }
            catch(ClassNotFoundException c){
                c.printStackTrace();
                Utilizador admin = new Utilizador("admin","admin","",Genero.ND,"","");
                try{
                    um.addUtilizador(admin);
                    um.setAdmin("admin",true);
                }
                catch(Exception e) {}
            }
        }
        else{
            Utilizador admin = new Utilizador("admin","admin","",Genero.ND,"","");
            try{
                um.addUtilizador(admin);
                um.setAdmin("admin",true);
            }
            catch(Exception e) {}
        }

        loginMenu(gc);

        try{
            FileOutputStream fileOut = new FileOutputStream("dados.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(um);
            out.close();
            fileOut.close();
        }catch(IOException i){
            i.printStackTrace();
        }
    }
}
