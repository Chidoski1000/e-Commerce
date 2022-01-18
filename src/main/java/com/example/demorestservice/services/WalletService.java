package com.example.demorestservice.services;

import com.example.demorestservice.entities.Product;
import com.example.demorestservice.entities.Wallet;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WalletService {

    Wallet addWallet(Wallet wallet);

    Wallet getWallet(Long walletId);

    Double getWalletBalance(Long walletId);

    Double updateWalletBalance(Long walletId, Double amount);

    List<Wallet> getAllWallet();


}
