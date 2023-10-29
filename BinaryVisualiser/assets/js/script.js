const levers = $('.lever');
const bits = Array(8).fill(0);

levers.each(function (index) {
  $(this).on("click", () => {
    bits[index] = bits[index] ? 0 : 1;
    let imgUrl = bits[index] ? 'assets/img/lever_down.png' : 'assets/img/lever_up.png';
    let imgAlt = bits[index] ? 'Binary Lever Down' : 'Binary Lever Up';
    $(this).attr({ 'src': imgUrl, 'alt': imgAlt });
    workOut();
  });
});

function workOut() {
  let binary1 = bits.slice(0, 4).join('');
  let binary2 = bits.slice(4).join('');
  let decimal = parseInt(binary1, 2) * 16 + parseInt(binary2, 2);
  let hexadecimal1 = parseInt(binary1, 2).toString(16).toUpperCase();
  let hexadecimal2 = parseInt(binary2, 2).toString(16).toUpperCase();

  $('#binary1').text(binary1);
  $('#binary2').text(binary2);
  $('#decimal').text(decimal);
  $('#hexadecimal1').text(hexadecimal1);
  $('#hexadecimal2').text(hexadecimal2);
  // Add octal at one point???
}
