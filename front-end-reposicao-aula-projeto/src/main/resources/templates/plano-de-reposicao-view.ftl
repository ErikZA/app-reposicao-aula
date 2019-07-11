<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Gerencia Planos De Reposição</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    
        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <h1>Gerenciamento do Plano de Reposição</h1>
            <p>Essa página é responsável por fazer o geranciamento do Plano de Reposição. </p>
        </div>
        <div class="row">
            <div class="col">
                <form action="/plano/criar" method="post">
                    <div class="form-group">
                            <label for="motivoSaida">Motivo Saida:</label>
                            <select class="form-control" id="motivoSaida" name="motivoSaida">
                                <option id="motivoSaidaPrevista" name="motivoSaidaPrevista">PREVISTA</option>
                                <option id="motivoSaidaInprevista" name="motivoSaidaInprevista">IMPREVISTA</option>
                                <option id="motivoSaidaNaoInformada" name="motivoSaidaNaoInformada">NAO_INFORMADA</option>
                              </select>
                        </div>
                         <div class="form-group">
                                <label for="motivoComentario">Motivo / Comentario:</label>
                                <input value="${(ausencia.motivoComentario)!}"  name="motivoComentario" type="text" class="form-control" id="motivoComentario">
                            </div>
                    <div class="form-group">
                        <label for="dataSaida">Data da Saida:</label>
                        <input value="${(ausencia.dataSaida)!}" name="dataSaida" type="text" class="form-control" id="dataSaida">
                    </div>
                    <div class="form-group">
                        <label for="dataRetorno">Data da Retorno:</label>
                        <input value="${(ausencia.dataRetorno)!}" name="dataRetorno" type="text" class="form-control" id="dataRetorno">
                    </div>
                        <div class="form-group">
                            <label for="dataAula">Data da Reposição:</label>
                            <input value="${(diario.dataAula)!}" name="dataAula" type="text" class="form-control" id="dataAula">
                        </div>
                    <div class="form-group">
                        <label for="conteudoReposicao">Conteudo Reposição:</label>
                        <input value="${(plano.conteudoReposicao)!}"  name="conteudoReposicao" type="text" class="form-control" id="conteudoReposicao">
                    </div>
                    <div class="form-group">
                        <label for="aprovacaoAlunos">Porcentagen de Alunos que Aprovão:</label>
                        <input value="${(plano.aprovacaoAlunos)!}"  name="aprovacaoAlunos" type="number" class="form-control" id="aprovacaoAlunos">
                    </div>
                    <div class="form-group">
                        <label for="quantidadeDeAulas">Aulas a serem Aplicadas:</label>
                        <input value="${(plano.quantidadeDeAulas)!}"  name="quantidadeDeAulas" type="number" class="form-control" id="quantidadeDeAulas">
                    </div>   
                    <div class="form-group">
                        <label for="categoria">Categoria da Reposição:</label>
                        <select class="form-control" id="categoria" name="categoria">
                            <option id="PRESENCIAL" name="PRESENCIAL">PRESENCIAL</option>
                            <option id="NAO_PRESENCIAL" name="NAO_PRESENCIAL">NAO_PRESENCIAL</option>
                          </select>
                    </div>
                    <div class="form-group">
                        <label for="aprovar">Aprovar Plano: (Tarefa do Cordenador)</label>
                        <div><label><input value="Aprovado" name="aprovar" type="radio" class="form-control" id="aprovar" disabled>Aprovado</label></div>
                        <div><label><input value="Reprovado" name="aprovar" type="radio" class="form-control" id="aprovar" disabled>Reprovado</label></div>
                        <div><label><input value="Pendente" name="aprovar" type="radio" class="form-control" id="aprovar" disabled checked>Pendente</label></div>

                    </div>

                    <button type="submit" class="btn btn-primary">Criar</button>
                </form>
            </div>

        </div>
        <div class="row">
            <div class="col">
                <table class="table table-striped table-hover table-responsive">
                    <thead class="thead-dark">
                        <tr>
                            <th>Motivo Saida</th>
                            <th>Data Saida</th>
                            <th>Data Retorno</th>
                            <th>Data Reposição</th>
                            <th>conteudo Reposicao</th>
                            <th>Aprovado Pelos Alunos</th>
                            <th>Aulas Repostas</th>
                            <th>Categoria Reposição</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list planos as plano>
                            <tr>
                                <#list ausencias as ausencia>
                                        <#if plano.ausencia == ausencia.id>
                                            <th>${ausencia.motivoComentario}</th>
                                        </#if>

                                        <#if plano.ausencia == ausencia.id>
                                            <th>${ausencia.dataSaida}</th>
                                        </#if>

                                        <#if plano.ausencia == ausencia.id>
                                            <th>${ausencia.dataRetorno}</th>
                                        </#if>

                                            <#list diarios as diario>
                                                <#if ausencia.diario == diario.id>
                                                    <th>${diario.dataAula}</th>
                                                </#if>
                                            </#list>
                                </#list>
                                    <th>${plano.conteudoReposicao}</th>
                                    <th>${plano.aprovacaoAlunos}</th>
                                    <th>${plano.quantidadeDeAulas}</th>
                                    <th>${plano.categoria}</th>
                            </tr>        
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>