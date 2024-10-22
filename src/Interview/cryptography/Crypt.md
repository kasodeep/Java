### Provider

- A provider in the Java Cryptographic API is a package or module that implements cryptographic algorithms.
- Java allows us to install different providers and load them.
- The default provider by the Security is SunJCE, which contains AES, RSA and SHA algorithms.

### Cipher Algorithms

#### AES

    It is block cipher that operates on 128-bit blocks and can use key sizes of 128, 192, 256 bits.

#### Modes Of Operation

1. ECB (Electronic Codebook Mode)

   Each block of plain text is encrypted individually using same size key.
   The data is split into blocks and each block is encrypted separately.

2. CBC (Cipher Block Chaining Mode)

   Each plaintext block is XORed with the previous ciphertext block before being encrypted.
   The first block uses an IV instead of previous block which hides the pattern.
   ```shell
   P1, P2, P3
   C1 = Enc(P1 + IV), C2 = Enc(P2 + C1)
   ```

3. CFB (Cipher Feedback Mode)

   Similar to CBC, but we XOR with the result of encryption of previous cypher block.
   ```shell
   C1 = Enc(IV) + P1, C2 = Enc(C1) + P2
   ```

4. OFB (Output Feedback Mode)

   The IV is encrypted first, and it's result is XORed with the plaintext to produce the ciphertext.
   In next block, we encrypt the Enc(IV) and then XOR the result.
   ```shell
   C1 = P1 + Enc(IV), C2 = P2 + Enc(Enc(IV))
   ```

5. CTR (Counter Mode)

   Each block is XORed with an encrypted counter value.
   The counter is incremented for each subsequent block.
   ```shell
   C1 = P1 + Enc(IV + 1), C2 = P2 + Enc(IV + 2)
   ```