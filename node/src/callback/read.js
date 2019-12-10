let fs = require('fs');
let data = fs.readdirSync('./readme');
console.log(data.toString());
