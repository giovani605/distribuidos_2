# distribuidos_2
Desenvolvimento de servidor para compartilhar arquivos utilizando Java RMI

- para funcionar o rmi vc deve modificar o arquivo de policy do java
este arquivo esta: C:\Program Files (x86)\Java\jre1.8.0\lib\security\java.policy
procura na pasta da sua jdk este arquivo.

em seguida para editar ele vc deve adiciona a seguinte linha
permission java.security.AllPermission;

dentro da chave // default permissions granted to all domains

grant {
...
 // vai ter uns cometarios aqui
 // cole a llinha
 permission java.security.AllPermission;
 }

// isso adiciona permissao total a todos os aplicativos
// fiz isso so para simplificar as coisas

PARA RODAR
vc deve rodar o server e o cliente separado.

