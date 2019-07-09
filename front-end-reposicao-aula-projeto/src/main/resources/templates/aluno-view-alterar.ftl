<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Gerencia Alunos</title>
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
            <h1>Gerenciamento de Alunos</h1>
            <p>Essa página é responsável por fazer o geranciamento de alunos. </p>
        </div>
        <div class="row">
            <div class="col">
                <form action="/aluno/alterar" method="post">
                    <div class="form-group">
                        <label for="name">Nome:</label>
                        <input value="${(alunoAtual.name)!}" name="name" type="text" class="form-control" id="name">
                    </div>
                    <div class="form-group">
                        <label for="matricula">Matricula:</label>
                        <input value="${(alunoAtual.matricula)!}"  name="matricula" type="number" class="form-control" id="matricula">
                    </div>
                    <div class="form-group">
                        <label for="curso">Curso:</label>
                        <input value="${(alunoAtual.curso)!}"  name="curso" type="text" class="form-control" id="curso">
                    </div>

                    <input type="hidden" name="id" value="${(alunoAtual.id)!}"></input>

                    <button type="submit" class="btn btn-warning">Alterar</button>
                </form>

            </div>
        </div>
        <div class="row">
            <div class="col">
                <table class="table table-striped table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>Nome</th>
                            <th>Matricula</th>
                            <th>Curso</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list alunos as aluno>
                            <tr>
                                <td>${aluno.name}</td>
                                <td>${aluno.matricula}</td>
                                <td>${aluno.curso}</td>
                                <td>
                                    <a href="/aluno/prepara-alterar?id=${aluno.id}">Alterar</a>
                                    <a href="/aluno/excluir?id=${aluno.id}">Excluir</a>
                                </td>
                            </tr>        
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>

</html>