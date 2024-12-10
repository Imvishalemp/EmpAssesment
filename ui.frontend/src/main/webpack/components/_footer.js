document.addEventListener("DOMContentLoaded", function() {
    // Get all elements with the class 'footerButton'
    var buttons = document.getElementsByClassName('footerButton');

    // Check if buttons exist and attach event listeners to each
    if (buttons.length > 0) {
        for (var i = 0; i < buttons.length; i++) {
            buttons[i].addEventListener('click', function() {
                alert('Button clicked!');
            });
        }
    }
});
