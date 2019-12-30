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

    @IBOutlet weak var label: UILabel!

    @IBOutlet weak var spinner: UIActivityIndicatorView!

    override func viewDidLoad() {
        super.viewDidLoad()
        label.text = CommonKt.createApplicationScreenMessage()

        spinner.startAnimating()
        let service = NasaApiService(api: NasaApi())
        service.getPictureOfDay() { [weak self] pod, error in
            if let pod = pod {
                self?.label.text = pod.title
            }
            if let error = error {
                self?.label.numberOfLines = 0
                self?.label.font = UIFont.preferredFont(forTextStyle: .body)
                self?.label.text = "\(error)"
            }
            self?.spinner.stopAnimating()
        }

    }


}
