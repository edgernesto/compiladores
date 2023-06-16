const grammatica = {
  S: ['AB', 'CSB'],
  A: ['aB', 'C'],
  B: ['bbB', 'b'],
};

function removerElementosComLetraC(obj) {
  if (typeof obj === 'string') {
    // Se o valor for uma string, verifique se contém 'C' maiúsculo
    if (obj.includes('C')) {
      return '';
    } else {
      return obj;
    }
  } else if (Array.isArray(obj)) {
    // Se o valor for um array, percorra cada elemento e chame a função novamente
    const newArray = [];
    for (let i = 0; i < obj.length; i++) {
      const modifiedItem = removerElementosComLetraC(obj[i]);
      if (modifiedItem !== '') {
        newArray.push(modifiedItem);
      }
    }
    return newArray;
  } else if (typeof obj === 'object') {
    // Se o valor for um objeto, percorra cada propriedade e chame a função novamente
    const newObj = {};
    for (let key in obj) {
      const modifiedValue = removerElementosComLetraC(obj[key]);
      if (modifiedValue !== '') {
        newObj[key] = modifiedValue;
      }
    }
    return newObj;
  } else {
    // Se o valor não for uma string, array ou objeto, retorne o valor original
    return obj;
  }
}

const novoGrammatica = removerElementosComLetraC(grammatica);

// Remover espaços vazios
const novoGrammaticaSemEspacosVazios = removerEspacosVazios(novoGrammatica);

// Renomear o objeto novoGrammaticaSemEspacosVazios e seus elementos
const renomeadoGrammatica = renomearElementos(novoGrammaticaSemEspacosVazios);

// Adicionar "a" na primeira posição do elemento A1
renomeadoGrammatica.A1[0] = 'a' + renomeadoGrammatica.A1[0];

console.log(renomeadoGrammatica);

// Função para remover espaços vazios
function removerEspacosVazios(obj) {
  if (typeof obj === 'string') {
    return obj.trim();
  } else if (Array.isArray(obj)) {
    return obj.filter(item => item !== '').map(removerEspacosVazios);
  } else if (typeof obj === 'object') {
    const newObj = {};
    for (let key in obj) {
      const value = obj[key];
      if (value !== '') {
        newObj[key] = removerEspacosVazios(value);
      }
    }
    return newObj;
  } else {
    return obj;
  }
}

// Função para renomear os elementos
function renomearElementos(obj) {
  if (typeof obj === 'string') {
    return obj.replace(/S/g, 'A1').replace(/A/g, 'A2').replace(/B/g, 'A3');
  } else if (Array.isArray(obj)) {
    return obj.map(renomearElementos);
  } else if (typeof obj === 'object') {
    const renamedObj = {};
    for (let key in obj) {
      let newKey = key;
      if (newKey === 'S') {
        newKey = 'A1';
      } else if (newKey === 'A') {
        newKey = 'A2';
      } else if (newKey === 'B') {
        newKey = 'A3';
      }
      renamedObj[newKey] = renomearElementos(obj[key]);
    }
    return renamedObj;
  } else {
    return obj;
  }
}
