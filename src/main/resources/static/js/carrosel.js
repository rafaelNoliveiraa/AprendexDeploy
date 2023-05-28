$(document).ready(function(){  // Aguarda o documento ser carregado antes de executar o código
    $('#tab0').slick({  // Seleciona o elemento com o ID "tab0" e aplica o plugin Slick
        dots: true,  // Habilita a exibição de pontos de navegação
        infinite: true,  // Habilita a rolagem infinita do carrossel
        speed: 500,  // Define a velocidade da transição dos slides em milissegundos
        slidesToShow: 1,  // Define o número de slides visíveis ao mesmo tempo
        adaptiveHeight: true,  // Ajusta a altura do carrossel automaticamente com base no conteúdo
        appendDots: $('.carousel-container'),  // Adiciona os pontos de navegação dentro do elemento com a classe "carousel-container"
        arrows: false,  // Remove os botões de navegação
        responsive: [  // Define configurações responsivas para diferentes larguras de tela
            {
                breakpoint: 768,  // Define a largura de tela em que as configurações a seguir serão aplicadas
                settings: {
                    arrows: false  // Remove os botões de navegação para telas com largura menor que 768 pixels
                }
            }
        ],
        autoplay: true,  // Habilita a reprodução automática do carrossel
        autoplaySpeed: 5000  // Define o tempo de pausa entre os slides durante a reprodução automática
    });
});