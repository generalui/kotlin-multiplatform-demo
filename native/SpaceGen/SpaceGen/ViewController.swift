//
//  ViewController.swift
//  SpaceGen
//
//  Created by Phil Mitchell on 12/20/19.
//  Copyright © 2019 GenUI. All rights reserved.
//

import UIKit
import shared

class ViewController: UIViewController {

    @IBOutlet weak var imageView: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        let service = NasaApiService(api: NasaApi())
        service.getPictureOfDay() { [weak self] pod, error in
            if let pod = pod,
               let image = pod.image {
                self?.imageView.image = image
            }
            if let error = error {
                print(error)
            }
        }

    }


}

