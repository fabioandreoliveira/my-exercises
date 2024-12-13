
            let score1 = 0;
            let score2 = 0;

            function play() {
                // Escolher aleatoriamente as jogadas dos jogadores
                let handlePlayer1 = Math.floor(Math.random() * 3); // 0: rock, 1: paper, 2: scissors
                let handlePlayer2 = Math.floor(Math.random() * 3);

                let imagesOptions = ["rock", "paper", "scissors"];

                // Atualizar imagens de cada jogador
                let player1 = document.getElementById("player1");
                player1.src = `/assets/${imagesOptions[handlePlayer1]}.png`;

                let player2 = document.getElementById("player2");
                player2.src = `/assets/${imagesOptions[handlePlayer2]}.png`;

                // Obter o elemento para mostrar a mensagem
                let message = document.getElementById("message");

                // Verificar quem venceu
                if (handlePlayer1 === handlePlayer2) {
                    message.innerHTML = "Empate! Nenhum jogador pontua.";
                } else if (
                    (handlePlayer1 === 0 && handlePlayer2 === 2) || // Pedra ganha de Tesoura
                    (handlePlayer1 === 1 && handlePlayer2 === 0) || // Papel ganha de Pedra
                    (handlePlayer1 === 2 && handlePlayer2 === 1)    // Tesoura ganha de Papel
                ) {
                    // Player 1 vence
                    score1 += 1;
                    message.innerHTML = "Player 1 vence esta rodada!";
                } else {
                    // Player 2 vence
                    score2 += 1;
                    message.innerHTML = "Player 2 vence esta rodada!";
                }

                // Atualizar as pontuações na tela
                document.getElementById("score1").innerHTML = score1;
                document.getElementById("score2").innerHTML = score2;
            }

            // Adicionar evento ao botão para jogar a rodada
            const replay = document.getElementById("button");
            replay.addEventListener("click", () => play());