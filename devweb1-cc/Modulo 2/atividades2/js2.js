var p = 2;
var q = 3;
var r = 12;
const S = 4.5;

document.write("<div> Resultado da expressão linha 1: " + (100 * (Math.pow(q,p)) + r) + "</div>");
document.write("<div> Resultado da expressão linha 2: " + (p * (r % 5) - (q/2))+ "</div>");
document.write("<div> Resultado da expressão linha 3: " + ((S - r) + Math.abs(Math.pow(q,2) - (r/4) * p - 3 ))+ "</div>");
document.write("<div> Resultado da expressão linha 4: " + (Math.sqrt(r + (Math.pow(p,2))) + S) + "</div>");
document.write("<div> Resultado da expressão linha 5: " + ((S % (p+1)) - (q*r)) + "</div>");
document.write("<div> Resultado da expressão linha 6: " + (6 + Math.pow(Math.pow(p, 3) + (2*r), 1/5) - Math.round(S - 1)) + "</div>");
document.write("<div> Resultado da expressão linha 7: " + (1 + Math.abs(r + S + Math.pow(q,2)) *  (2 * p * q - r))  + "</div>");
document.write("<div> Resultado da expressão linha 8: " + (p + (2.9 + Math.round(0.3+S) * 2)) + "</div>");
