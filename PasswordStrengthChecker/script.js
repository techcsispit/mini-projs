const criteria = [
    /[A-Z]/, // At least one uppercase letter
    /[a-z]/, // At least one lowercase letter
    /[0-9]/, // At least one digit
    /[!@#$%^&*()\-_=+{};:,<.>]/, // At least one special character
    /.{8,}/ // At least 8 characters long
];

const calculatePasswordStrength = password => {
    let strength = 0;
    for (const criterion of criteria) {
        if (criterion.test(password)) {
            strength++;
        }
    }
    return strength;
};

const container = document.querySelector('.container');
const passwordInput = document.querySelector('#myPassword');
const passwordInputs = document.querySelectorAll('input[type="password"]');

passwordInputs.forEach(passwordInput => {
    passwordInput.addEventListener('keydown', () => {
        const { value } = passwordInput;
        const strength = calculatePasswordStrength(value);

        container.className = 'container';
        switch (true) {
            case strength < 3:
                container.classList.add('weak');
                break;
            case strength < 5:
                container.classList.add('medium');
                break;
            default:
                container.classList.add('strong');
                break;
        }
    });

    
    const showHideButton = passwordInput.nextElementSibling;
    showHideButton.addEventListener('click', () => {
        const { type } = passwordInput;
        passwordInput.type = type === 'password' ? 'text' : 'password';
        showHideButton.classList.toggle('hide');
    });
});
